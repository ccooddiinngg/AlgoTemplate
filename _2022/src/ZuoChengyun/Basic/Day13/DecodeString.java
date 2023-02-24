package ZuoChengyun.Basic.Day13;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DecodeString {
    public static int decodeString(String s, int i, String path, List<String> res) {
        if (i >= s.length()) {
            res.add(path);
            return 1;
        }
        int o1 = 0;
        int o2 = 0;
        if (s.charAt(i) != '0') {
            o1 = decodeString(s, i + 1, path + (digitToLetter("" + s.charAt(i))), res);
        }
        if (i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && "0123456".contains("" + s.charAt(i + 1))))) {
            o2 = decodeString(s, i + 2, path + (digitToLetter("" + s.charAt(i) + s.charAt(i + 1))), res);
        }
        return o1 + o2;
    }

    private static char digitToLetter(String s) {
        return (char) (Integer.parseInt(s) - 1 + 'A');
    }

    @Test
    void decodeStringTest() {
        String s = "1017328251";
        List<String> res = new ArrayList<>();
        int count = decodeString(s, 0, "", res);
        System.out.println(count);
        System.out.println(res);
    }
}
