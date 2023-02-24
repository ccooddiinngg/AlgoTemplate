package AC2.A1;

import java.util.Arrays;
import java.util.Scanner;

public class A803 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair[] pairs = new Pair[n];

        for (int i = 0; i < pairs.length; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            pairs[i] = new Pair(first, second);
        }

        int count = countSection(pairs);
        System.out.println(count);
    }

    static int countSection(Pair[] pairs) {
        Arrays.sort(pairs, (a, b) -> a.first - b.first);
        int count = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < pairs.length; i++) {
            if (pairs[i].first > max) {
                count++;
                max = pairs[i].second;
            } else {
                max = Math.max(max, pairs[i].second);
            }
        }
        return count;
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
