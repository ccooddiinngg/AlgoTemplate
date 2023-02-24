package AC2.A1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A799 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int max = find(nums);
        System.out.println(max);
    }

    static int find(int[] nums) {
        int i = 0;
        int j = 0;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (j < nums.length) {
            if (map.containsKey(nums[j])) {
                max = Math.max(max, j - i);
                int t = map.get(nums[j]);
                while (i <= t) map.remove(nums[i++]);
            }
            map.put(nums[j], j);
            j++;
        }
        max = Math.max(max, j - i);
        return max;
    }

}
