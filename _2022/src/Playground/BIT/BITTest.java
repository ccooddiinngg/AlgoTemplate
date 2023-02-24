package Playground.BIT;

import org.junit.jupiter.api.Test;

class BITTest {

    @Test
    void test() {
        BIT bit = new BIT(10);
        bit.update(1, 1);
        bit.update(2, 4);
        bit.update(3, 3);
        bit.update(4, 2);
        bit.update(10, 11);
        System.out.println(bit.ask(4));
        System.out.println(bit.ask(8));
        System.out.println(bit.ask(10));

        System.out.println(bit.ask(10) - bit.ask(4 - 1));
    }

    @Test
    void test1() {
        int[] arr = {3, 2, 1, 4, 5};
        BIT bit = new BIT(arr.length);
        for (int i = 0; i < arr.length; i++) {
            bit.update(i + 1, arr[i]);
        }
        System.out.println(bit.ask(4));
        System.out.println(bit.ask(1, 2));

        bit.update(2, 1);
        System.out.println(bit.ask(1, 2));

    }
}