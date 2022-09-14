package template;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import template.KMP;

import java.util.List;

class KMPTest {

    @Test
    void test() {
        String s = "abababcaabac";
        String p = "aba";
        Assertions.assertEquals(List.of(0, 2, 8), KMP.kmp(s, p));
    }

}