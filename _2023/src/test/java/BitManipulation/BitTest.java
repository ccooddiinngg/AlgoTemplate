package BitManipulation;

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


}



