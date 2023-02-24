package ZuoChengyun.Middle.Day2;

import org.junit.jupiter.api.Test;

import java.util.*;

public class FindNumPair {
    public static List<int[]> find(int[] arr, int k) {
        List<int[]> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        for (int num : arr) {
            if (set.contains(num - k)) {
                list.add(new int[]{num, num - k});
            }
        }
        return list;
    }

    @Test
    void test() {
        int[] arr = {3, 2, 5, 7, 0};
        int k = 2;
        List<int[]> list = find(arr, k);
        for (int[] e : list) {
            System.out.println(Arrays.toString(e));
        }
    }
}
