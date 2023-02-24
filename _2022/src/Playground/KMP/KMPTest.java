package Playground.KMP;

import org.junit.jupiter.api.Test;

import java.util.List;

class KMPTest {
    KMP kmp = new KMP();

    @Test
    void test() {
        String s = "abababcaabac";
        String pat = "aba";
        List<Integer> list = kmp.kmp(s, pat);
        System.out.println(list);
    }
}