package ZuoChengyun.Middle.Day6;

public class ParseInteger {
    public static int parseInt(char[] chars) {
        boolean isNegative = chars[0] == '-';
        int minA = Integer.MIN_VALUE / 10;
        int minB = Integer.MIN_VALUE % 10;

        int res = 0;
        for (int i = isNegative ? 1 : 0; i < chars.length; i++) {
            int curr = '0' - chars[i];
            if (res < minA || (res == minA && curr < minB)) {
                throw new RuntimeException("out of bound");
            }
            res = res * 10 + curr;
        }
        if (!isNegative && res == Integer.MIN_VALUE) {
            throw new RuntimeException("out of bound");
        }
        return isNegative ? res : -res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        String s = "2147483647";
        System.out.println(parseInt(s.toCharArray()));
    }
}
