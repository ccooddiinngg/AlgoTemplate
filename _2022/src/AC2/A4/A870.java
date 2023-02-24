package AC2.A4;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class A870 {
    static int mod = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        long count = count(nums, n);
        System.out.println(count);
    }

    //约数的个数总共为 各个(质因子的个数 + 1) 的乘积
    static long count(int[] nums, int n) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            countPrime(nums[i], map);
        }
        long res = 1;
        for (int key : map.keySet()) {
            res = res * (map.get(key) + 1) % mod;
        }
        return res;
    }

    static void countPrime(int n, Map<Integer, Integer> map) {
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) {
                int count = 0;
                while (n % i == 0) {
                    count++;
                    n /= i;
                }
                int sum = (map.getOrDefault(i, 0) + count);
                map.put(i, sum);
            }
        }
        // 有余数 > 1 的情况一定是质数
        if (n > 1) {
            int sum = (map.getOrDefault(n, 0) + 1);
            map.put(n, sum);
        }
    }
}
