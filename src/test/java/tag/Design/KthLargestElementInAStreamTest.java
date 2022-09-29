package tag.Design;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

class KthLargestElementInAStreamTest {
    /*
    ["KthLargest","add","add","add","add","add"]
    [[2,[0]],[-1],[1],[-2],[-4],[3]]
    */
    @Test
    void test() throws Exception {
        Class<?> c = Class.forName("tag.Design.KthLargestElementInAStream");
        Constructor<?> constructor = c.getConstructor(int.class, int[].class);
        Object obj = constructor.newInstance(2, new int[]{0});
        Method add = c.getDeclaredMethod("add", int.class);
//        add.setAccessible(true);
        Assertions.assertEquals(-1, add.invoke(obj, -1));
        Assertions.assertEquals(0, add.invoke(obj, 1));
        Assertions.assertEquals(0, add.invoke(obj, -2));
        Assertions.assertEquals(0, add.invoke(obj, -4));
        Assertions.assertEquals(1, add.invoke(obj, 3));

    }
}