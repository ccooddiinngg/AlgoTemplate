package Playground;

import java.util.Arrays;

public class StringDemo {
    public static void main(String[] args) {
        String S = "ab.cd";
        String[] ss = S.split("\\.");
        System.out.println(Arrays.toString(ss));

        String[] strs = {"123", "312"};
        Arrays.sort(strs, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        System.out.println(Arrays.toString(strs));
        String join = String.join("", strs);
        System.out.println(join);
    }
}
