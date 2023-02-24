package Leetcode.Coding_Interview_6.C17;

import org.junit.jupiter.api.Test;

import java.util.List;

class S22Test {
    S22 s22 = new S22();

    @Test
    void test() {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(s22.findLadders(beginWord, endWord, wordList));
    }

    @Test
    void test1() {
        String beginWord = "a";
        String endWord = "c";
        List<String> wordList = List.of("a", "b", "c");
        System.out.println(s22.findLadders(beginWord, endWord, wordList));
    }
}