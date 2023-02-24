package ZuoChengyun.Middle.Day4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FindPrimeNums {
    public static List<Integer> find(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                list.add(i);
                n /= i;
            }
        }
        return list;
    }

    @Test
    void test() {
        int n = 2837;
        System.out.println(find(n));
    }
}
