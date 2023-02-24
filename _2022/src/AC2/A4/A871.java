package AC2.A4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A871 {
    static int mod = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        long count = count(nums, n, new HashMap<>());
        System.out.println(count % mod);
    }

    //如果 N = p1^c1 ∗ p2^ c2 ∗ … ∗ pk ^ ck
    //约数个数：(c1+1) ∗ (c2+1) ∗ … ∗ (ck+1)
    //约数之和： (p1^0 + p1^1 + … + p1^c1) ∗ … ∗ (pk^0 + pk^1 + … + pk^ck)
    static long count(int[] nums, int n, Map<Integer, Integer> map) {
        for (int i = 0; i < n; i++) {
            countPrime(nums[i], map);
        }
        long res = 1;
        for (int key : map.keySet()) {
            long sum = 0;
            long pow = 1;
            for (int i = 0; i <= map.get(key); i++) {
                sum = (sum + pow) % mod;
                pow = pow * key % mod;
            }
            res = res * sum % mod;
        }
        return res;
    }

    static void countPrime(int num, Map<Integer, Integer> map) {
        for (int i = 2; i <= num / i; i++) {
            if (num % i == 0) {
                int count = 0;
                while (num % i == 0) {
                    count++;
                    num /= i;
                }
                map.put(i, map.getOrDefault(i, 0) + count);
            }
        }
        if (num > 1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
    }
}