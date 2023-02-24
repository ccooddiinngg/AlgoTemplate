package ZuoChengyun.Middle.Day1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BuyApple {
    public static int main(int[] bags, int apple) {
        if (apple == 0) return -1;
        List<Integer> list = new ArrayList<>();
        buy(bags, 0, apple, 0, list);
//        System.out.println(list);
        int max = Integer.MAX_VALUE;
        for (Integer i : list) {
            max = Math.min(max, i);
        }
        return max == Integer.MAX_VALUE ? -1 : max;
    }

    public static void buy(int[] bags, int index, int rest, int sum, List<Integer> list) {
        if (rest == 0) {
            list.add(sum);
            return;
        }
        if (index >= bags.length) return;
        for (int i = 0; i * bags[index] <= rest; i++) {
            buy(bags, index + 1, rest - i * bags[index], sum + i, list);
        }
    }

    //打表找规律
    public static int print(int apple) {
        if (apple == 0 || apple % 2 == 1) return -1;
        if (apple < 18) {
            return apple == 6 || apple == 8 ? 1 : apple == 12 || apple == 14 | apple == 16 ? 2 : -1;
        }
        return (apple - 18) / 8 + 3;
    }

    @Test
    void test() {
        int[] bags = {6, 8};

        for (int i = 0; i < 1000000; i++) {
            int apple = new Random().nextInt(100);
            int v1 = main(bags, apple);
            int v2 = print(apple);
            if (v1 != v2) {
                System.out.println(apple + "-->" + v1 + " -- " + v2);
                System.out.println("error!");
                break;
            }
        }
    }
}
