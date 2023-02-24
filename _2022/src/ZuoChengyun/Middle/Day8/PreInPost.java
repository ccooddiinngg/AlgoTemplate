package ZuoChengyun.Middle.Day8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class PreInPost {
    public static void build(Integer[] pre, int i1, int j1, Integer[] in, int i2, int j2, Integer[] post, int i3, int j3) {
        if (i3 > j3) {
            return;
        }
        post[j3] = pre[i1];
        //can use in map search index
        int h = List.of(in).indexOf(pre[i1]);
        int l = h - i2;
        build(pre, i1 + 1, i1 + l, in, i2, i2 + l - 1, post, i3, i3 + l - 1);
        build(pre, i1 + l + 1, j1, in, i2 + l + 1, j2, post, i3 + l, j3 - 1);
    }

    @Test
    void test() {
//        Integer[] pre = {1, 2, 4, 5, 3, 6, 7};
        Integer[] pre = {1, 2, 3};
//        Integer[] in = {4, 2, 5, 1, 6, 3, 7};
        Integer[] in = {2, 1, 3};
        int m = in.length;
        Integer[] post = new Integer[m];

        build(pre, 0, m - 1, in, 0, m - 1, post, 0, m - 1);
        System.out.println(Arrays.toString(post));
    }
}
