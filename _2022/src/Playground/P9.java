package Playground;

import java.util.HashMap;
import java.util.Map;

public class P9 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        String s123 = "123";
        String s234 = "234";
        String s345 = "345";
        String s456 = "456";
        put(s123, s234, map);
        map.put("123", "234");
        System.out.println(map);
    }

    static void put(String s1, String s2, Map<String, String> map) {
        map.put(s1, s2);
    }
}
