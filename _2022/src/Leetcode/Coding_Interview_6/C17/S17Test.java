package Leetcode.Coding_Interview_6.C17;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class S17Test {
    S17 s17 = new S17();

    @Test
    void test() {
        String big = "mississippi";
        String[] words = {"is", "ppi", "hi", "sis", "i", "ssippi"};
        System.out.println(Arrays.deepToString(s17.multiSearch(big, words)));
    }

}