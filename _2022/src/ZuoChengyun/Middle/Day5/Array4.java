package ZuoChengyun.Middle.Day5;

import java.util.Map;

public class Array4 {
    public static boolean find(int[] arr) {
        //only has one 4 factor
        int count4 = 0;
        //only has one 2 factor
        int count2 = 0;
        int countOdd = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                if (arr[i] % 4 == 0) {
                    count4++;
                } else {
                    count2++;
                }
            } else {
                countOdd++;
            }
        }
        if (count2 == 0) {
            if (countOdd == 1) return count4 >= 1;
            if (countOdd > 1) return count4 >= countOdd - 1;
            return true;
        } else {
            return count4 >= countOdd;
        }
    }
}
