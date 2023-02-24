package Leetcode.Coding_Interview_6.C08;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class S08aTest {
    S08a s08a = new S08a();

    @Test
    void test() {
        String s = "java";
        String[] res = s08a.permutation(s);
        System.out.println(Arrays.toString(res));
    }

}