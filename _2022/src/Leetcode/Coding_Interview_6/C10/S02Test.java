package Leetcode.Coding_Interview_6.C10;

import org.junit.jupiter.api.Test;

import java.util.List;

class S02Test {
    S02 s02 = new S02();

    @Test
    void test() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = s02.groupAnagrams(strs);
        System.out.println(list);
    }
}