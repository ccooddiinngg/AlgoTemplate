package template;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import template.LIS;

class LISTest {
    @Test
    void test() {
        int[] arr = {50, 3, 10, 7, 40, 80};
        Assertions.assertEquals(4, LIS.lis(arr));
    }

}