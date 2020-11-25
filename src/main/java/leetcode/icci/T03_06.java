package leetcode.icci;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author DubLBo
 * @since 2020-10-22 23:09
 * i believe i can i do
 */
public class T03_06 {
}

class AnimalShelf_0 {

    private LinkedList<int[]> animals;

    public AnimalShelf_0() {
        animals = new LinkedList<>();
    }

    public void enqueue(int[] animal) {
        animals.offer(animal);
    }

    public int[] dequeueAny() {
        if (animals.isEmpty()) return new int[]{-1, -1};
        return animals.poll();
    }

    public int[] dequeueDog() {
        for (int[] animal : animals) {
            if (animal[1] == 1) {
                animals.remove(animal);
                return animal;
            }
        }
        return new int[]{-1, -1};
    }

    public int[] dequeueCat() {
        for (int[] animal : animals) {
            if (animal[1] == 0) {
                animals.remove(animal);
                return animal;
            }
        }
        return new int[]{-1, -1};
    }
}

// 注意到动物的编号是自增的
class AnimalShelf {

    private Queue<int[]> dogs;
    private Queue<int[]> cats;

    public AnimalShelf() {
        dogs = new LinkedList<>();
        cats = new LinkedList<>();
    }

    public void enqueue(int[] animal) {
        if (animal[1] == 0) {
            cats.add(animal);
        } else {
            dogs.add(animal);
        }
    }

    public int[] dequeueAny() {
        if (cats.isEmpty() && dogs.isEmpty()) return new int[]{-1, -1};
        if (cats.isEmpty()) return dogs.poll();
        if (dogs.isEmpty()) return cats.poll();
        return cats.peek()[0] < dogs.peek()[0] ? cats.poll() : dogs.poll();
    }

    public int[] dequeueDog() {
        return dogs.isEmpty() ? new int[]{-1,-1} : dogs.poll();
    }

    public int[] dequeueCat() {
        return cats.isEmpty() ? new int[]{-1,-1} : cats.poll();
    }

}
