package Leetcode.MostInterView;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    static Comparator<String> com = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            String s1 = o2 + o1;
            String s2 = o1 + o2;
            return s1.compareTo(s2);
        }
    };

    public static String largestNumber(int[] nums) {
        String[] numbers = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numbers[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numbers, com);
        if (numbers[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            sb.append(numbers[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {34, 3, 30, 9, 5};
        System.out.println(largestNumber(nums));
    }

}
