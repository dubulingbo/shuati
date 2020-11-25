package leetcode.icci;

import java.util.*;

/**
 * @author DubLBo
 * @since 2020-11-12 16:15
 * i believe i can i do
 */
public class T17_07 {
    // ["John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"], synonyms = ["(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"]
    //输出：["John(27)","Chris(36)"]

    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        // HashMap + 并查集
        if (names.length == 0 || synonyms.length == 0) return names;

        // 存放名对应的编号
        HashMap<String, Integer> nameMap = new HashMap<>();
        // 存放标号对应的名字，便于通过节点编号快速找到响应的名字
        HashMap<Integer, String> indexMap = new HashMap<>();
        // 存放名称对
        List<String[]> data = new ArrayList<>();
        // 记录并查集中的节点个数
        int nodeNum = 0;

        // 初始化一些数据
        for (String s : synonyms) {
            String[] namePair = s.substring(1, s.length() - 1).split(",");
            data.add(new String[]{namePair[0], namePair[1]});
            if (!nameMap.containsKey(namePair[0])) {
                nameMap.put(namePair[0], nodeNum);
                indexMap.put(nodeNum, namePair[0]);
                nodeNum++;
            }
            if (!nameMap.containsKey(namePair[1])) {
                nameMap.put(namePair[1], nodeNum);
                indexMap.put(nodeNum, namePair[1]);
                nodeNum++;
            }
        }


        // 建立并查集
        int[] parent = new int[nodeNum];
        Arrays.fill(parent, -1);
        for (String[] ss : data) {
            if (!ss[0].equals(ss[1])) {
                union(parent, nameMap.get(ss[0]), nameMap.get(ss[1]), indexMap);
            }
        }

        // 循环 names，统计同类姓名的出现频率
        Map<String, Integer> resMap = new HashMap<>();
        for (String s : names) {
            int index = s.indexOf('(');
            String name = s.substring(0, index);
            int num = Integer.parseInt(s.substring(index + 1, s.length() - 1));
            if (nameMap.containsKey(name)) {
                int root = find(parent, nameMap.get(name));
                name = indexMap.get(root);
            }
            resMap.put(name, resMap.getOrDefault(name, 0) + num);
        }

        // 封装结果
        String[] res = new String[resMap.size()];
        nodeNum = 0;
        for (Map.Entry<String, Integer> entry : resMap.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            res[nodeNum++] = key + "(" + value + ")";
        }
        return res;
    }

    private void union(int[] parent, int i, int j, HashMap<Integer, String> indexMap) {
        int iRoot = find(parent, i);
        int jRoot = find(parent, j);
        if (iRoot != jRoot) {
            // 这个合并的时候需要注意，应该让较小的字符串成为较大的字符串的父亲
            String iName = indexMap.get(iRoot);
            String jName = indexMap.get(jRoot);
            if (iName.compareTo(jName) < 0) {
                parent[jRoot] = iRoot;
            } else {
                parent[iRoot] = jRoot;
            }
        }
    }

    private int find(int[] parent, int k) {
        while (parent[k] != -1) {
            k = parent[k];
        }
        return k;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new T17_07().trulyMostPopular(
                new String[]{"John(15)", "Jon(12)", "Chris(13)", "Kris(4)", "Christopher(19)"},
                new String[]{"(Jon,John)", "(John,Johnny)", "(Chris,Kris)", "(Chris,Christopher)"})));
    }
}
