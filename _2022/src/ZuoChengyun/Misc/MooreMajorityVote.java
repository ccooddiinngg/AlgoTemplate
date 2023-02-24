package ZuoChengyun.Misc;

import java.util.HashMap;
import java.util.Map;

public class MooreMajorityVote {

    //find a num , which frequency > length /2
    public static void main(String[] args) {
        int[] array = {1, 2, 2, 2, 2, 2, 3, 4, 5};
        int max1 = find1(array);
        int max2 = find2(array);
        System.out.println(max1);
        System.out.println(max2);
    }

    //hashmap
    public static int find1(int[] array) {
        int m = array.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int count = map.getOrDefault(array[i], 0);
            map.put(array[i], count + 1);
        }
        int count = 0;
        int num = array[0];
        for (Integer key : map.keySet()) {
            if (map.get(key) > count) {
                count = map.get(key);
                num = key;
            }
        }
        return count > m / 2 ? num : -1;
    }

    //remove 2 different nums every time
    public static int find2(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int curr = array[0];
        int count = 1;

        for (int i = 1; i < array.length; i++) {
            if (count == 0) {
                curr = array[i];
                count++;
            } else {
                if (array[i] != curr) {
                    count--;
                } else {
                    count++;
                }
            }
        }
        if (count > 0) {
            int max = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == curr) {
                    max++;
                }
            }
            if (max > array.length / 2) {
                return curr;
            }
        }
        return -1;
    }
}
