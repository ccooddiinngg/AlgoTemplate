package String;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class KMPTest {
    KMP kmp = new KMP();

    @Test
    void test() {
        String s = "abababcaabac";
        String p = "aba";
        Assertions.assertEquals(List.of(0, 2, 8), kmp.kmp(s, p));
    }

}