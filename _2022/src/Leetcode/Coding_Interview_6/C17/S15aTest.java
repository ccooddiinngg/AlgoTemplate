package Leetcode.Coding_Interview_6.C17;

import org.junit.jupiter.api.Test;

class S15aTest {
    S15a s15a = new S15a();

    @Test
    void test() {
        String[] words = {"cat", "banana", "dog", "nana", "walk", "walker", "dogwalker"};
        System.out.println(s15a.longestWord(words));
    }

}