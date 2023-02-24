package ZuoChengyun.Basic.Day13;

import org.junit.jupiter.api.Test;

public class CardGame {

    public static int p1(int[] cards, int left, int right) {
        if (left == right) {
            return cards[left];
        }
        int oLeft = p2(cards, left + 1, right) + cards[left];
        int oRight = p2(cards, left, right - 1) + cards[right];
        return Math.max(oLeft, oRight);
    }

    public static int p2(int[] cards, int left, int right) {
        if (left == right) {
            return 0;
        }
        int oLeft = p1(cards, left + 1, right);
        int oRight = p1(cards, left, right - 1);
        return Math.min(oLeft, oRight);
    }

    @Test
    void playTest() {
        int[] cards = {4, 7, 9, 5, 1, 3, 10, 2, 6, 8};
        int sum = 0;
        for (int card : cards) {
            sum += card;
        }
        System.out.println(sum);
        int scoreP1 = p1(cards, 0, cards.length - 1);
        int scoreP2 = p2(cards, 0, cards.length - 1);
        System.out.println(scoreP1);
        System.out.println(scoreP2);
    }
}
