package tag.DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

public class StoneGameVI {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int m = aliceValues.length;
        P[] sum = new P[m];
        for (int i = 0; i < m; i++) {
            sum[i] = new P(aliceValues[i], bobValues[i]);
        }
        Arrays.sort(sum, Comparator.comparingInt(a -> (a.a + a.b)));
        int a = 0;
        int b = 0;
        for (int i = m - 1; i >= 0; i -= 2) {
            a += sum[i].a;
            b += i - 1 >= 0 ? sum[i - 1].b : 0;
        }
        return Integer.compare(a, b);
    }

    class P {
        int a;
        int b;

        public P(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    /*When one takes the stone, they not only get the points, but they take them away from the other player too.*/
    /*Greedily choose the stone with the maximum aliceValues[i] + bobValues[i].*/
}
