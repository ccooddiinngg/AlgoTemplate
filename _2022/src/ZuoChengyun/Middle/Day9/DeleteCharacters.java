package ZuoChengyun.Middle.Day9;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class DeleteCharacters {
    //delete redundant chars and try to keep a-z sequence
    public static String delete(String s) {
        if (s.equals("")) {
            return "";
        }
        int[] map = new int[256];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
        }

        int min = 0;
        for (int i = 0; i < s.length(); i++) {
            min = s.charAt(i) < s.charAt(min) ? i : min;
            if (--map[s.charAt(i)] == 0) {
                break;
            }
        }

        return s.charAt(min) + delete(s.substring(min + 1).replaceAll(String.valueOf(s.charAt(min)), ""));
    }

    @Test
    void test() {
        String s = "dbcacbca";
        System.out.println(delete(s));
    }
}
