package Leetcode.EveryDay;

import org.junit.jupiter.api.Test;

import java.util.Set;

public class LC468 {
    public String validIPAddress(String queryIP) {
        int n = queryIP.length();
        String[] msg = {"Neither", "IPv4", "IPv6"};
        if (queryIP.contains(".") && queryIP.charAt(0) != '.' && queryIP.charAt(n - 1) != '.') {
            String[] strs = queryIP.split("\\.");
            if (strs.length != 4) {
                return msg[0];
            }
            for (String str : strs) {
                if (str.equals("")) return msg[0];
                for (char c : str.toCharArray()) {
                    if (!Character.isDigit(c)) {
                        return msg[0];
                    }
                }
                if (str.length() > 3) return msg[0];
                if (str.length() > 1 && str.charAt(0) == '0') return msg[0];
                int num = Integer.parseInt(str);
                // System.out.println(num);
                if (num > 255) {
                    return msg[0];
                }
            }
            return msg[1];
        }
        if (queryIP.contains(":") && queryIP.charAt(0) != ':' && queryIP.charAt(n - 1) != ':') {
            Set<Character> letters = Set.of('a', 'b', 'c', 'd', 'e', 'f');
            String[] strs = queryIP.split(":");
            if (strs.length != 8) {
                return msg[0];
            }
            for (String str : strs) {
                if (str.equals("")) return msg[0];
                if (str.length() > 4 && !(str.length() == 1 && str.charAt(0) == '0')) {
                    return msg[0];
                }
                for (char c : str.toCharArray()) {
                    if (!Character.isDigit(c) && !letters.contains(Character.toLowerCase(c))) {
                        return msg[0];
                    }
                }
            }
            return msg[2];
        }
        return msg[0];
    }

    @Test
    void test() {
        String s1 = "172.16.254.1";
        String s2 = "2001:0db8:85a3:0:0:8A2E:0370:7334";
        String s3 = "192.0.0.1";
        System.out.println(validIPAddress(s3));
    }
}
