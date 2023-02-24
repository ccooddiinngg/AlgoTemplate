package ZuoChengyun.Basic.Day15;

import ZuoChengyun.Basic.Utils.Utils;
import org.junit.jupiter.api.Test;

public class CardGameDP {

    public static int p1DP(int[] cards) {
        int length = cards.length;
        int[][] dp1 = new int[length][length];
        int[][] dp2 = new int[length][length];
        for (int i = 0; i < dp1.length; i++) {
            dp1[i][i] = cards[i];
        }
        for (int l = 1; l < length; l++) {
            for (int j = l, i = 0; j < length; j++, i++) {
                dp1[i][j] = Math.max(dp2[i + 1][j] + cards[i], dp2[i][j - 1] + cards[j]);
                dp2[i][j] = Math.min(dp1[i + 1][j], dp1[i][j - 1]);
            }
        }
        Utils.print2DArray(dp1);

        Utils.print2DArray(dp2);

        return dp1[0][length - 1];
    }

    @Test
    void playTest() {
        int[] cards = {4, 7, 9, 5, 1, 3, 10, 2, 6, 8};
        int i = p1DP(cards);
        System.out.println(i);
    }
}
