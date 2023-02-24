package Leetcode.Offer;

public class O05 {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        String str = "%20";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append(str);
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
