package Leetcode.Coding_Interview_6.C03;

import java.util.LinkedList;

public class S06 {
    class AnimalShelf {
        LinkedList<int[]> list;

        public AnimalShelf() {
            list = new LinkedList<>();
        }

        public void enqueue(int[] animal) {
            int[] ani = new int[2];
            ani[0] = animal[0];
            ani[1] = animal[1];
            list.add(ani);
        }

        public int[] dequeueAny() {
            if (!list.isEmpty()) {
                int[] res = list.get(0);
                list.remove(0);
                return res;
            } else {
                return new int[]{-1, -1};
            }
        }

        int[] dequeue(int ani) {
            int i = 0;
            while (i < list.size() && list.get(i)[1] != ani) {
                i++;
            }
            if (i < list.size()) {
                int[] res = list.get(i);
                list.remove(i);
                return res;
            } else {
                return new int[]{-1, -1};
            }
        }

        public int[] dequeueDog() {
            return dequeue(1);
        }

        public int[] dequeueCat() {
            return dequeue(0);
        }
    }
}
