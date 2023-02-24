package Leetcode.ACW_LeetCode;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class LC860 {
    public boolean lemonadeChange(int[] bills) {
        int[] changes = new int[3];
        Map<Integer, Integer> map1 = Map.of(20, 0, 10, 1, 5, 2);
        Map<Integer, Integer> map2 = Map.of(0, 20, 1, 10, 2, 5);
        for (int i = 0; i < bills.length; i++) {
            changes[map1.get(bills[i])]++;
            int change = bills[i] - 5;
            for (int j = 0; j < changes.length; j++) {
                while (change >= map2.get(j) && changes[j] > 0) {
                    change -= map2.get(j);
                    changes[j]--;
                }
            }
            if (change > 0) return false;
        }
        return true;
    }

    @Test
    void test() {
        int[] bills = {5, 5, 5, 10, 20};
        System.out.println(lemonadeChange(bills));
    }
}
