package ZuoChengyun.Middle.Day5;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Coffee {
    public static List<Integer> timeline(int[] arr, int N) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        int max = 0;
        for (int i = 1; i < arr[arr.length - 1] * N; i++) {
            for (int t : arr) {
                if (i % t == 0) {
                    max += 1;
                    list.add(i);
                }
            }
            if (max >= N) {
                break;
            }
        }
        return list;
    }

    //todo
    //using min heap

    public static int clean(int[] timeline, int machineAvailable, int index, int a, int b) {
        if (index == timeline.length - 1) {
            int wash = Math.max(machineAvailable, timeline[index]) + a;
            int dry = timeline[index] + b;
            return Math.min(wash, dry);
        }
        int wash = Math.max(machineAvailable, timeline[index]) + a;
        int washNext = clean(timeline, wash, index + 1, a, b);

        int dry = timeline[index] + b;
        int dryNext = clean(timeline, machineAvailable, index + 1, a, b);
        return Math.min(Math.max(wash, washNext), Math.max(dry, dryNext));
    }

    @Test
    void test() {
        int[] arr = {3, 2, 7};
        System.out.println(timeline(arr, 5));
    }
}
