package AC2_Course.Hash;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


//802. 区间和
public class A802 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/ACWING/Hash/A837Data.txt"));
        int n = sc.nextInt();
        int q = sc.nextInt();

        List<Integer> indices = new ArrayList<>();
        List<Pair> operation = new ArrayList<>();
        List<Pair> query = new ArrayList<>();
        int[] values = new int[300000];
        int[] pre = new int[300000];

        int idx = 0;
        int val = 0;
        for (int i = 0; i < n; i++) {
            idx = sc.nextInt();
            val = sc.nextInt();
            operation.add(new Pair(idx, val));
            indices.add(idx);
        }

        for (int i = 0; i < q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            query.add(new Pair(l, r));
            indices.add(l);
            indices.add(r);
        }
        Collections.sort(indices);
        unique(indices);

        for (Pair pair : operation) {
            values[search(pair.first, indices)] += pair.second;
        }

        for (int i = 1; i < values.length; i++) {
            pre[i] = pre[i - 1] + values[i - 1];
        }

        for (Pair pair : query) {
            int sum = pre[search(pair.second, indices) + 1] - pre[search(pair.first, indices)];
            System.out.println(sum);
        }
    }

    private static int search(int idx, List<Integer> indices) {
        int i = 0;
        int j = indices.size() - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (indices.get(mid) == idx) {
                return mid;
            } else if (indices.get(mid) > idx) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return -1;
    }

    private static void unique(List<Integer> indices) {
        int j = 0;
        for (int i = 0; i < indices.size(); i++) {
            if (indices.get(i) != indices.get(j)) {
                j++;
                indices.set(j, indices.get(i));
            }
        }
        indices.subList(j + 1, indices.size());
    }

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
