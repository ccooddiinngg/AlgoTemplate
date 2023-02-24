package ZuoChengyun.BasicPlus.Day2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SlidingWindow {

    public static int[] findMaxNums(int[] array, int w) {
        AMonotonicQueue aMonotonicQueue = new AMonotonicQueue(array, (o1, o2) -> o1 - o2);
        int[] result = new int[array.length - w + 1];
        int j = 0;
        while (aMonotonicQueue.right < w) {
            aMonotonicQueue.rightIncrease();
        }
        result[j++] = aMonotonicQueue.peek();
        while (j < result.length) {
            aMonotonicQueue.rightIncrease();
            aMonotonicQueue.leftIncrease();
            result[j++] = aMonotonicQueue.peek();
        }
        return result;
    }

    public static int[] bruteforce(int[] arr, int w) {
        int[] res = new int[arr.length - w + 1];
        int i = 0;
        int j = i + w;
        int max;
        while (j <= arr.length) {
            max = arr[i];
            for (int k = i + 1; k < j; k++) {
                if (arr[k] > max) {
                    max = arr[k];
                }
            }
            res[i] = max;
            i++;
            j++;
        }
        return res;
    }

    @Test
    void test() {
        int[] array = {4, 3, 5, 4, 3, 3, 6, 7, 5};
        int[] maxNumbers = bruteforce(array, 6);
        System.out.println(Arrays.toString(maxNumbers));

        System.out.println(Arrays.toString(findMaxNums(array, 6)));
    }
}
