package Leetcode.Coding_Interview_6.C16;

public class S10 {
    public int maxAliveYear(int[] birth, int[] death) {
        int start = 1900;
        int end = 2000;
        int[] year = new int[end - start + 2];
        for (int i = 0; i < birth.length; i++) {
            year[birth[i] - start]++;
            year[death[i] - start + 1]--;
        }
        int max = -1;
        int[] count = new int[end - start + 2];
        count[0] = year[0];
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i - 1] + year[i];
            if (max == -1 || (count[max] < count[i])) {
                max = i;
            }
        }
        return max + start;
    }
}
