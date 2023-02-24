package AC2_Course.BinaryIndexedTree;

import org.junit.jupiter.api.Test;

class FenwickTreeTest {
    @Test
    void test() {
        int[] arr = {3, 2, 1, 4, 5};
        FenwickTree fenwickTree = new FenwickTree(arr.length);
        for (int i = 0; i < arr.length; i++) {
            fenwickTree.update(i, arr[i]);
        }
        System.out.println(fenwickTree.ask(4));
        System.out.println(fenwickTree.ask(1, 2));

        fenwickTree.update(2, 1);
        System.out.println(fenwickTree.ask(1, 2));

    }

}