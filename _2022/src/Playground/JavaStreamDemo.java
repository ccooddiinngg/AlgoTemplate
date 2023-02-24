package Playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class JavaStreamDemo {
    public static void main(String[] args) {
        List<Integer> list = Stream.of(1, 2, 3, 4, 5).filter(a -> a > 2).map(a -> a * a).toList();
        System.out.println(list);

        String[] s = {"1", "2", "3"};
        System.out.println(Arrays.toString(s));
        int[] nums = Stream.of(s).mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.toString(nums));

        List<P> list2 = new ArrayList<>();
        list2.add(new P(5, 1));
        list2.add(new P(3, 1));
        list2.add(new P(2, 2));
        list2.add(new P(4, 3));
        list2.add(new P(1, 3));
        P[] list2Array = list2.stream().sorted(Comparator.comparingInt(a -> a.x)).toArray(P[]::new);
        System.out.println(Arrays.toString(list2Array));

        int[] nums1 = {1, 34, 2, 345};
        String[] strs1 = Arrays.stream(nums1).mapToObj(String::valueOf).toArray(String[]::new);
        System.out.println(Arrays.toString(strs1));
    }

    static class P {
        int x;
        int y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "P{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }


}
