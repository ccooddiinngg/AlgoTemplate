package AC2.A5;

import java.util.*;

public class A285 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] happy = new int[N + 1];
        for (int i = 1; i < happy.length; i++) {
            happy[i] = sc.nextInt();
        }
        int[] pre = new int[N + 1];
        Arrays.fill(pre, -1);

        for (int i = 0; i < N - 1; i++) {
            int emp = sc.nextInt();
            int boss = sc.nextInt();
            pre[emp] = boss;
        }

        int head = -1;
        for (int i = 1; i < pre.length; i++) {
            if (pre[i] == -1) {
                head = i;
                break;
            }
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i < N + 1; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 1; i < pre.length; i++) {
            if (pre[i] != -1) {
                map.get(pre[i]).add(i);
            }
        }

//        int max = Math.max(getMax(map, head, true, happy), getMax(map, head, false, happy));
        int[][] dp = new int[N + 1][2];
        fill(dp, map, happy, N, 5);
        int max = Math.max(dp[head][0], dp[head][1]);
        System.out.println(max);
    }

    //bruteforce
    static int getMax(Map<Integer, List<Integer>> map, int curr, boolean show, int[] happy) {
        if (map.get(curr).size() == 0) {
            return show ? happy[curr] : 0;
        }
        int h = 0;
        if (show) {
            h += happy[curr];
            for (int next : map.get(curr)) {
                h += getMax(map, next, !show, happy);
            }
        } else {
            for (int next : map.get(curr)) {
                h += Math.max(getMax(map, next, show, happy), getMax(map, next, !show, happy));
            }
        }
        return h;
    }

    static void fill(int[][] dp, Map<Integer, List<Integer>> map, int[] happy, int N, int curr) {
        dp[curr][1] = happy[curr];
        for (int next : map.get(curr)) {
            fill(dp, map, happy, N, next);
            dp[curr][1] += dp[next][0];
            dp[curr][0] += Math.max(dp[next][0], dp[next][1]);
        }
    }
}
