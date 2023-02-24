package ZuoChengyun.Basic.Day13;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class Permutation {

    public static void subString(String s, int i, String buffer, Set<String> set) {
        if (i == s.length()) {
            set.add(buffer);
            return;
        }
        subString(s, i + 1, buffer, set);
        subString(s, i + 1, buffer + s.charAt(i), set);
    }

    @Test
    void subStringTest() {
        String s = "abcd";
        Set<String> set = new HashSet<>();
        Permutation.subString(s, 0, "", set);
        System.out.println(set);
    }

    public static void permutation(String s, int l, String buffer, Set<Integer> set, Set<String> res) {
        if (l == s.length()) {
            res.add(buffer);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(i)) {
                set.add(i);
                permutation(s, l + 1, buffer + s.charAt(i), set, res);
                set.remove(i);
            }
        }
    }

    @Test
    void permutationTest() {
        String s = "aab";
        Set<String> set = new HashSet<>();
        permutation(s, 0, "", new HashSet<>(), set);
        System.out.println(set);
    }
}
