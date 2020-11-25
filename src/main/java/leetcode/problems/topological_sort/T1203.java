package leetcode.problems.topological_sort;

import java.util.*;

/**
 * @author DubLBo
 * @since 2020-11-06 20:18
 * i believe i can i do
 */
public class T1203 {
    /**
     * 基类，用于拓扑排序
     **/
    private static class Sortable {
        // 表示某个节点的编号：这里指的是项目id 和 组id
        public int id;
        // 当前节点的后继节点，这里为啥要使用集合呢？
        public Set<Sortable> next;

        public Sortable(int id) {
            this.id = id;
            this.next = new HashSet<>();
        }
    }

    /**
     * 项目类
     **/
    private static class Project extends Sortable {
        public Project(int id) {
            super(id);
        }
    }

    /**
     * 项目所属组类
     **/
    private static class Group extends Sortable {
        // 项目组所负责的项目，因为一个组可以负责多个项目
        // 存储项目 id 对应的项目
        public Map<Integer, Project> pros;
        // 各项目节点入度
        // 存储项目 id 对应的入度
        public Map<Integer, Integer> proInDegrees;

        public Group(int id) {
            super(id);
            this.pros = new HashMap<>();
            this.proInDegrees = new HashMap<>();
        }
    }

    /**
     * 拓扑排序结果类
     **/
    private static class SortResult {
        // 标记本次能不能得到一种拓扑排序，默认为 false
        public boolean success;
        // 排序结果列表
        public List<Sortable> result;

        public SortResult(boolean success, List<Sortable> result) {
            this.success = success;
            this.result = result;
        }
    }

    // 存储以项目组为节点构成的图
    private Map<Integer, Group> groups;
    // 项目组各节点的入度
    private Map<Integer, Integer> groupInDegrees;

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        // 初始化一些基础数据
        preHandle(n, m, group, beforeItems);
        // 首先进行项目组的拓扑排序
        SortResult sortedGroup = topologicalSort(groups, groupInDegrees);
        if (!sortedGroup.success) return new int[0];
        int[] ans = new int[n];
        int cur = 0;

        for (Sortable s : sortedGroup.result) {
            Group g = (Group) s;
            SortResult sortedPros = topologicalSort(g.pros, g.proInDegrees);
            if (!sortedPros.success) return new int[0];
            for (Sortable ss : sortedPros.result) {
                Project p = (Project) ss;
                ans[cur++] = p.id;
            }
        }
        return ans;
    }

    /**
     * 拓扑排序
     *
     * @param graph  待排序的图
     * @param indegs 图中各节点的入度
     * @return 排序的结果
     */
    private SortResult topologicalSort(Map<Integer, ? extends Sortable> graph, Map<Integer, Integer> indegs) {
        List<Sortable> list = new ArrayList<>();
        Queue<Sortable> queue = new LinkedList<>();

        for (Map.Entry<Integer, Integer> entry : indegs.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(graph.get(entry.getKey()));
            }
        }

        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                Sortable tmp = queue.poll();
                for (Sortable s : tmp.next) {
                    int inNum = indegs.get(s.id);
                    if (inNum == 1) queue.offer(s);
                    indegs.put(s.id, inNum - 1);
                }
                list.add(tmp);
            }
        }

        boolean success = list.size() == graph.size();
        return new SortResult(success, list);
    }

    private void preHandle(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        Project[] pros = new Project[n];
        groups = new HashMap<>();
        groupInDegrees = new HashMap<>();
        // 额外使用 m 个项目组之外的数量
        int num = 0;
        for (int i = 0; i < n; i++) {
            pros[i] = new Project(i);
            // 如果当前项目还未分配组，直接分配 m 个组之外的组
            if (group[i] == -1) group[i] = (m + num++);
        }

        for (int i = 0; i < m + num; i++) {
            groups.put(i, new Group(i));
            // 起始时，各项目组的入度为 0
            groupInDegrees.put(i, 0);
        }

        for (int i = 0; i < n; i++) {
            Group curGroup = groups.get(group[i]);
            curGroup.pros.put(i, pros[i]);
            curGroup.proInDegrees.put(i, 0);
        }

        for (int i = 0; i < n; i++) {
            Group cur = groups.get(group[i]);
            for (int j : beforeItems.get(i)) {
                if (group[i] == group[j]) {
                    pros[j].next.add(pros[i]);
                    cur.proInDegrees.compute(i, (k, v) -> v + 1);
                } else {
                    groups.get(group[j]).next.add(cur);
                }
            }
        }

        for (Map.Entry<Integer, Group> entry : groups.entrySet()) {
            Group g = entry.getValue();
            for (Sortable next : g.next) {
                groupInDegrees.compute(next.id, (k, v) -> v + 1);
            }
        }
    }
}
