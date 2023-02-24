package AC2.A1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class A802 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();


        Pair[] op = new Pair[n];
        Pair[] q = new Pair[m];
        int[] indices = new int[300000];
        int index = 0;

        for (int i = 0; i < n; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            op[i] = new Pair(first, second);
            indices[index++] = first;
        }
        for (int i = 0; i < m; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            q[i] = new Pair(first, second);
            indices[index++] = first;
            indices[index++] = second;
        }
        List<Integer> list = removeDuplicate(indices);
        int[] values = new int[list.size()];
        int[] pre = new int[list.size() + 1];
        for (Pair p : op) {
            values[indexOf(list, p.first)] += p.second;
        }

        for (int i = 1; i < pre.length; i++) {
            pre[i] = pre[i - 1] + values[i - 1];
        }
        for (Pair p : q) {
            int res = pre[indexOf(list, p.second) + 1] - pre[indexOf(list, p.first)];
            System.out.println(res);
        }
    }

    static List<Integer> removeDuplicate(int[] indices) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(indices);
        for (int i = 0; i < indices.length; i++) {
            if (i == 0 || indices[i] != indices[i - 1]) {
                list.add(indices[i]);
            }
        }
        return list;
    }

    static int indexOf(List<Integer> list, int t) {
        int l = 0;
        int r = list.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) == t) {
                return mid;
            } else if (list.get(mid) > t) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    static class Pair {
        int first;
        int second;

        public Pair(int f, int s) {
            first = f;
            second = s;
        }
    }
}


