package ZuoChengyun.Basic.Day13;

import org.junit.jupiter.api.Test;

import java.util.*;

import static ZuoChengyun.Basic.Utils.Utils.print;
import static ZuoChengyun.Basic.Utils.Utils.swap;

public class Day13 {
    //use chars in order
    void permutation(String string, int n, String buffer, List<String> list) {
        if (n == string.length()) {
            list.add(buffer);
            return;
        }
        String s = buffer + string.charAt(n);
        permutation(string, n + 1, s, list);
        permutation(string, n + 1, buffer, list);
    }

    @Test
    void test1() {
        String string = "aba";
        List<String> list = new ArrayList<>();
        permutation(string, 0, "", list);
        Set<String> set = new HashSet<>(list);
        print(list);
        print(set);
    }

    //use all chars
    void permutation(char[] chars, int n, List<String> list) {
        if (n == chars.length) {
            list.add(Arrays.toString(chars));
            return;
        }
        /* remove duplicate */
        Set<Character> set = new HashSet<>();
        for (int i = n; i < chars.length; i++) {
            if (!set.contains(chars[i])) {
                set.add(chars[i]);
                swap(chars, i, n);
                permutation(chars, n + 1, list);
                swap(chars, i, n);
            }
        }
    }

    @Test
    void test2() {
        String string = "abc";
        char[] chars = string.toCharArray();
        List<String> list = new ArrayList<>();
        permutation(chars, 0, list);
        print(list);
    }

    /**
     * @param weight        weight array
     * @param value         value array
     * @param currentWeight current weight
     * @param maxWeight     max weight
     * @param index         current item
     * @return max value
     */
    //Backpack
    int value(int[] weight, int[] value, int currentWeight, int maxWeight, int index) {
        if (index >= weight.length) {
            return 0;
        }
        int vNext1 = 0;
        if (currentWeight + weight[index] <= maxWeight) {
            vNext1 = value(weight, value, currentWeight + weight[index], maxWeight, index + 1) + value[index];
        }

        int vNext0 = value(weight, value, currentWeight, maxWeight, index + 1);

        return Math.max(vNext0, vNext1);
    }

    int value(int[] weight, int[] value, int index, int space) {
        if (index >= weight.length) {
            return 0;
        }
        int v1 = 0;
        if (space - weight[index] >= 0) {
            v1 = value[index] + value(weight, value, index + 1, space - weight[index]);
        }
        int v0 = value(weight, value, index + 1, space);
        return Math.max(v1, v0);
    }

    @Test
    void test3() {
        int[] weight = {1, 2, 3, 4};
        int[] value = {2, 3, 2, 8};
        int maxWeight = 6;
        int max1 = value(weight, value, 0, maxWeight, 0);
        int max2 = value(weight, value, 0, maxWeight);
        System.out.printf("max value %d", max1);
        System.out.printf("max value %d", max2);
    }

    //cards game
    int cardValueFirst(int[] cards, int left, int right) {
        if (left == right) {
            return cards[left];
        }
        return Math.max(cards[left] + cardValueSecond(cards, left + 1, right), cards[right] + cardValueSecond(cards, left, right - 1));
    }

    int cardValueSecond(int[] cards, int left, int right) {
        if (left == right) {
            return 0;
        }
        return Math.min(cardValueFirst(cards, left + 1, right), cardValueFirst(cards, left, right - 1));
    }

    @Test
    void test4() {
        int[] cards = {4, 7, 9, 5, 1, 3, 10, 2, 6, 8};
        int max = cardValueFirst(cards, 0, cards.length - 1);
        System.out.println(max);
    }
}
