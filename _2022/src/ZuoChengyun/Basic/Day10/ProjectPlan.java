package ZuoChengyun.Basic.Day10;

import java.util.*;

public class ProjectPlan {

    public static int bruteForce(List<Integer[]> projects, int money, int K, int count) {
        if (count > K || projects.size() == 0) {
            return money;
        }
        int max = money;
        for (Integer[] p : projects) {
            if (p[0] <= money) {
                List<Integer[]> next = new ArrayList<>(projects);
                next.remove(p);
                max = Math.max(max, bruteForce(next, money + p[1], K, count + 1));
            }
        }
        return max;
    }

    //search for the most profit project in the heap that satisfied
    public static int greedyHeap(List<Integer[]> projects, int start, int K) {
        Queue<Integer[]> waitingList = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        Queue<Integer[]> satisfied = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);

        waitingList.addAll(projects);
        int money = start;
        int count = 0;
        while (count < K) {
            while (!waitingList.isEmpty() && waitingList.peek()[0] <= money) {
                satisfied.add(waitingList.poll());
            }
            if (!satisfied.isEmpty()) {
                Integer[] p = satisfied.poll();
                money += p[1];
                count++;
            } else {
                break;
            }
        }
        return money;
    }

    public static void main(String[] args) {
        Integer[] p1 = {1, 3};
        Integer[] p2 = {1, 1};
        Integer[] p3 = {4, 3};
        Integer[] p4 = {5, 2};
        List<Integer[]> projects = new ArrayList<>(Arrays.asList(p1, p2, p3, p4));

        int profit = bruteForce(projects, 1, 4, 1);
        System.out.println(profit);

        int profitGreedy = greedyHeap(projects, 1, 4);
        System.out.println(profitGreedy);
    }
}
