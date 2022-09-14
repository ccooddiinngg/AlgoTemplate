package template;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import template.BIT;

class BITTest {
    BIT bit = new BIT(10);

    @Test
    void test() {
        Assertions.assertEquals(0, bit.ask(4));
        Assertions.assertEquals(0, bit.ask(4, 8));
        Assertions.assertEquals(0, bit.ask(1, 10));

        bit.update(1, 1);
        bit.update(2, 3);
        bit.update(5, 2);
        bit.update(5, 2);
        bit.update(9, 1);
        bit.update(9, 1);
        bit.update(9, 1);

        Assertions.assertEquals(4, bit.ask(1, 2));
        Assertions.assertEquals(4, bit.ask(1, 4));
        Assertions.assertEquals(7, bit.ask(2, 6));
        Assertions.assertEquals(3, bit.ask(2, 4));
        Assertions.assertEquals(11, bit.ask(1, 10));
        Assertions.assertEquals(7, bit.ask(3, 10));
    }

    @Test
    void test1() {
        int[] arr = {3, 2, 1, 4, 5};
        for (int i = 0; i < arr.length; i++) {
            bit.update(i + 1, arr[i]);
        }
        Assertions.assertEquals(10, bit.ask(4));
        Assertions.assertEquals(5, bit.ask(1, 2));

        bit.update(2, 1);
        Assertions.assertEquals(6, bit.ask(1, 2));

    }
}