package ZuoChengyun.Basic.Day13;

import org.junit.jupiter.api.Test;

public class Backpack {

    public static int backpack(int[] weights, int[] values, int rest, int i) {
        if (i == weights.length) {
            return 0;
        }
        int v0 = backpack(weights, values, rest, i + 1);
        int v1 = 0;
        if (rest >= weights[i]) {
            v1 = backpack(weights, values, rest - weights[i], i + 1) + values[i];
        }
        return Math.max(v0, v1);
    }

    @Test
    void backpackTest() {
        int[] weights = {1, 4, 2, 3};
        int[] values = {3, 11, 3, 7};
        int MAX = 6;

        int totalValue = backpack(weights, values, MAX, 0);
        System.out.println(totalValue);
    }
}
