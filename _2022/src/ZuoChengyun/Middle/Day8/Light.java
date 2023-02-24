package ZuoChengyun.Middle.Day8;

import org.junit.jupiter.api.Test;

public class Light {
    //1 can set light, 0 not
    public static int find(int[] arr, int index) {
        if (index >= arr.length) {
            return 0;
        }
        if (arr[index] == 1) {
            int v0 = 0;
            int v1 = 0;
            if (index < arr.length - 1 && arr[index + 1] == 1) {
                v0 = 1 + find(arr, index + 3);
                return v0;
            }
            v1 = 1 + find(arr, index + 2);
            return v1;
        } else {
            return find(arr, index + 1);
        }
    }

    @Test
    void test() {
        int[] arr = {1, 1, 1, 1, 1, 1};
        System.out.println(find(arr, 0));
    }
}
