package tag.DynamicProgramming;

import org.junit.jupiter.api.Test;

import java.util.List;

class PalindromePartitioningTest {
    PalindromePartitioning palindromePartitioning = new PalindromePartitioning();

    @Test
    void test() {
        String s = "aabaabaabaaaabaabaabaa";
        List<List<String>> list = palindromePartitioning.partition(s);
    }

    @Test
    void test1() {
        String s = "aabaabaabaaaabaabaabaa";
        List<List<String>> list = palindromePartitioning.partition1(s);
    }

}