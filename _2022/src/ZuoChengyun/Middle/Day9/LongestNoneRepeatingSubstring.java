package ZuoChengyun.Middle.Day9;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class LongestNoneRepeatingSubstring {
    public static int find(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), -1);
        }
        int max = 0;
        //之前能推到的最大下标
        int pre = -1;
        for (int i = 0; i < s.length(); i++) {
            pre = Math.max(pre, map.get(s.charAt(i)));
            max = Math.max(max, i - pre);
            map.put(s.charAt(i), i);
        }
        return max;
    }

    @Test
    void test() {
        String s = "abcabccbb";
        System.out.println(find(s));
    }

}
