package Leetcode.Coding_Interview_6.C17;

import org.junit.jupiter.api.Test;

class S13Test {
    S13 s13 = new S13();

    @Test
    void test() {
        String[] dic = {"looked", "just", "like", "her", "brother"};
        String text = "jesslookedjustliketimherbrother";
        System.out.println(s13.respace(dic, text));
    }

}