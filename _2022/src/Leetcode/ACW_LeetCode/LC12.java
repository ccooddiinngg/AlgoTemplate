package Leetcode.ACW_LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC12 {
//    我们用来确定罗马数字的规则是：对于罗马数字从左到右的每一位，选择尽可能大的符号值。
//    对于 140，最大可以选择的符号值为 C=100。
//    接下来，对于剩余的数字 40，最大可以选择的符号值为 XL=40。
//    因此，140 的对应的罗马数字为 C+XL=CXL

    public String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<>(Map.of(1, "I", 4, "IV", 5, "V", 9, "IX", 10, "X", 40, "XL", 50, "L", 90, "XC", 100, "C"));
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        List<Integer> keys = new ArrayList<>(map.keySet());
        keys.sort((a, b) -> b - a);
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            for (int key : keys) {
                if (num >= key) {
                    sb.append(map.get(key));
                    num -= key;
                    break;
                }
            }
        }
        return sb.toString();
    }
}
