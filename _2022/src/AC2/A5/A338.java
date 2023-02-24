package AC2.A5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A338 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            if (from == 0 && to == 0) break;

            if (from > to) {
                int t = from;
                from = to;
                to = t;
            }
            int[] cnt = count(from, to);
            for (int c : cnt) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    private static int[] count(int from, int to) {
        int[] fromCnt = count0to9(from - 1);
        int[] toCnt = count0to9(to);
        for (int i = 0; i < 10; i++) {
            toCnt[i] -= fromCnt[i];
        }
        return toCnt;
    }

    static int[] count0to9(int x) {
        int[] cnt = new int[10];
        for (int digit = 0; digit < 10; digit++) {
            cnt[digit] += countI(x, digit);
        }
        return cnt;
    }

    //return : from 1 - x, i (0 1 2...9) frequency
    static int countI(int x, int digit) {
        List<Integer> list = new ArrayList<>();
        int x1 = x;
        while (x1 > 0) {
            list.add(x1 % 10);
            x1 /= 10;
        }
        int cnt = 0;

        int bit = digit == 0 ? 1 : 0;
        for (int i = list.size() - 1 - bit; i >= 0; i--) {
            if (i != list.size() - 1) {
                if (digit == 0) {
                    cnt += (getNum(list, list.size() - 1, i + 1) - 1) * pow(i);
                } else {
                    cnt += (getNum(list, list.size() - 1, i + 1)) * pow(i);
                }
            }

            if (list.get(i) > digit) {
                cnt += pow(i);
            } else if (list.get(i) == digit) {
                cnt += getNum(list, i - 1, 0) + 1;
            }

        }
        return cnt;
    }

    static int pow(int n) {
        return (int) Math.pow(10, n);
    }

    //[3,4,1] high: 1, low: 0, res = 41
    static int getNum(List<Integer> list, int high, int low) {
        int res = 0;
        for (int i = high; i >= low; i--) {
            res = res * 10 + list.get(i);
        }
        return res;
    }

}
