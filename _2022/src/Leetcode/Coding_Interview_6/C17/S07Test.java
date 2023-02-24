package Leetcode.Coding_Interview_6.C17;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class S07Test {
    @Test
    void test() {
        S07 s07 = new S07();
        String[] names = {"John(15)", "Jon(12)", "Chris(13)", "Kris(4)", "Christopher(19)"};
        String[] synonyms = {"(Jon,John)", "(John,Johnny)", "(Chris,Kris)", "(Chris,Christopher)"};
        String[] strs = s07.trulyMostPopular(names, synonyms);
        System.out.println(Arrays.toString(strs));
    }
}