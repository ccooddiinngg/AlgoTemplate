package Leetcode.Coding_Interview_6.C17;

import org.junit.jupiter.api.Test;

class S15Test {
    S15 s15 = new S15();

    @Test
    void test() {
        String[] words = {"cat", "banana", "dog", "nana", "walk", "walker", "dogwalker"};
        System.out.println(s15.longestWord(words));
    }

}