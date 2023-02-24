package Leetcode.Coding_Interview_6.C10;

public class S05 {
    public int findString(String[] words, String s) {
        int n = words.length;
        int i = 0;
        int j = n - 1;
        while (i <= j) {
            int mid = (j + i) >> 1;
            //向左向右都可以
            while (mid > i && words[mid].equals("")) mid--;
            if (words[mid].compareTo(s) == 0) {
                return mid;
            } else if (words[mid].compareTo(s) > 0) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return -1;
    }
}
