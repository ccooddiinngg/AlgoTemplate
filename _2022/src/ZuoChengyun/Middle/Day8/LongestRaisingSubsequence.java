package ZuoChengyun.Middle.Day8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LongestRaisingSubsequence {

    //[3,4,2,5,6,7,1] -> [3,4,5,6,7]
    public static int find(int[] arr) {
        int[] end = new int[arr.length + 1];
        int index = 1;
        end[index++] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int left = 1;
            int right = index;
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (end[mid] > arr[i]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            end[right] = arr[i];
            if (right == index)
                index++;
        }
        System.out.println(Arrays.toString(end));
        return index - 1;
    }

    @Test
    void test() {
        int[] arr = {3, 4, 2, 5, 6, 7, 1};
        System.out.println(find(arr));
    }
}
