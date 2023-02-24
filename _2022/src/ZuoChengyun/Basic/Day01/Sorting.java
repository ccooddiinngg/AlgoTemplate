package ZuoChengyun.Basic.Day01;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import static ZuoChengyun.Basic.Utils.Utils.*;

public class Sorting {

    void sort(int[] unsorted, Consumer<int[]> fn) {
        fn.accept(unsorted);
    }

    Consumer<int[]> insertionSort = unsorted -> {
        for (int i = 1; i < unsorted.length; i++) {
            for (int j = i; j > 0 && unsorted[j] < unsorted[j - 1]; j--) {
                swap(unsorted, j, j - 1);
            }
        }
    };

    Consumer<int[]> bubbleSort = unsorted -> {
        for (int i = 0; i < unsorted.length; i++) {
            boolean isSorted = true;
            for (int j = 1; j < unsorted.length - i; j++) {
                if (unsorted[j] < unsorted[j - 1]) {
                    isSorted = false;
                    swap(unsorted, j, j - 1);
                }
            }
            if (isSorted) {
                break;
            }
        }
    };

    Consumer<int[]> selectionSort = unsorted -> {
        for (int i = 0; i < unsorted.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < unsorted.length; j++) {
                if (unsorted[j] < unsorted[min]) {
                    min = j;
                }
            }
            swap(unsorted, min, i);
        }
    };

    @Test
    void test1() {
        int[] unsorted = createRandomIntArray(10000);
        sort(unsorted, insertionSort);
        System.out.println(isSorted(unsorted));
    }

    @Test
    void test2() {
        int[] unsorted = createRandomIntArray(10000);
        sort(unsorted, bubbleSort);
        System.out.println(isSorted(unsorted));
    }

    @Test
    void test3() {
        int[] unsorted = createRandomIntArray(10000);
        sort(unsorted, selectionSort);
        System.out.println(isSorted(unsorted));
    }
}


