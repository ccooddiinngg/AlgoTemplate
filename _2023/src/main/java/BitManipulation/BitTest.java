package BitManipulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class BitTest {
    @Test
    void test() {
        List<String> ans = findRepeatedDnaSequences("GAGAGAGAGAGA");
        System.out.println(ans);
    }

    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> set = new HashSet<>();
        Set<String> res = new HashSet<>();
        int[] map = new int[128];
        map['A'] = 0;
        map['C'] = 1;
        map['G'] = 2;
        map['T'] = 3;
        int i = 0;
        int j = 0;
        int num = 0;

        while (j < s.length()) {
            if (j >= 10) {
                num -= (map[s.charAt(i)] << 18);
                i++;
            }
            num = (num << 2) | map[s.charAt(j)];
            j++;
            if (j >= 10 && !set.add(num)) {
                res.add(s.substring(i, j));
            }
        }
        return new ArrayList<>(res);
    }

    @Test
    void test1() {
        List<String> ans = List.of("0:03", "0:05", "0:06", "0:09", "0:10", "0:12", "0:17", "0:18", "0:20", "0:24", "0:33", "0:34", "0:36", "0:40", "0:48", "1:01", "1:02", "1:04", "1:08", "1:16", "1:32", "2:01", "2:02", "2:04", "2:08", "2:16", "2:32", "3:00", "4:01", "4:02", "4:04", "4:08", "4:16", "4:32", "5:00", "6:00", "8:01", "8:02", "8:04", "8:08", "8:16", "8:32", "9:00", "10:00");
        List<String> list = readBinaryWatch(2);
        Assertions.assertEquals(ans.size(), list.size());
        for (String s : ans) {
            Assertions.assertTrue(list.contains(s));
        }
    }

    public List<String> readBinaryWatch(int turnedOn) {
        int H = 4;
        int M = 6;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < H && i <= turnedOn; i++) {
            List<Integer> hours = new ArrayList<>();
            dfs(i, H - 1, 0, hours, 11);
            List<Integer> mins = new ArrayList<>();
            dfs(turnedOn - i, M - 1, 0, mins, 59);
            for (int h : hours) {
                for (int m : mins) {
                    list.add(toString(h, m));
                }
            }
        }
        return list;
    }

    //0000
    //000000
    void dfs(int count, int idx, int path, List<Integer> list, int max) {
        if (path > max) return;
        if (count == 0) {
            list.add(path);
            return;
        }
        if (count < 0 || idx == -1) return;
        dfs(count - 1, idx - 1, path + (1 << idx), list, max);
        dfs(count, idx - 1, path, list, max);
    }

    String toString(int hour, int min) {
        String h = hour + "";
        String m = min == 0 ? "00" : min < 10 ? "0" + min : min + "";
        return h + ":" + m;
    }

    @Test
    void test2() {
        int maxChoosableInteger = 20;
        int desiredTotal = 210;
        Assertions.assertFalse(canIWin(maxChoosableInteger, desiredTotal));
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        cache = new int[desiredTotal][1 << maxChoosableInteger];
        return dfs(maxChoosableInteger, desiredTotal, 0, 0);
    }

    int[][] cache;

    public boolean dfs(int maxChoosableInteger, int desiredTotal, int curr, int state) {
        if (cache[curr][state] != 0) return cache[curr][state] == 1;
        for (int i = 0; i < maxChoosableInteger; i++) {
            if ((state >> i & 1) == 0) {
                if (curr + (i + 1) >= desiredTotal || !dfs(maxChoosableInteger, desiredTotal, curr + (i + 1), state + (1 << i))) {
                    cache[curr][state] = 1;
                    return true;
                }
            }
        }
        cache[curr][state] = 2;
        return false;
    }
}



