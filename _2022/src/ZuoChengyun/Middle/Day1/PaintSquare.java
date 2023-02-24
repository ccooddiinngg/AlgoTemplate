package ZuoChengyun.Middle.Day1;

import org.junit.jupiter.api.Test;

public class PaintSquare {
    public static int find(String s) {
        int g = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'G') {
                g++;
            }
        }
        int min = g;
        int countR = 0;
        int countG = g;
        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i - 1) == 'R') {
                countR++;
            } else {
                countG--;
            }
            min = Math.min(min, countR + countG);
        }
        return min;
    }

    @Test
    void test() {
        String s = "RGGRRGG";
        System.out.println(find(s));
    }
}
