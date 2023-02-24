package ZuoChengyun.Middle.Day10;

import org.junit.jupiter.api.Test;

public class SubSequence {

    public static int find(int index) {
        int res = 1;

        for (int i = index + 1; i < 26; i++) {
            res += find(i);
        }
        return res;
    }

    public static int main() {
        int total = 0;
        for (int i = 0; i < 26; i++) {
            total += find(i);
        }
        return total;
    }

    @Test
    void test() {
        System.out.println(main());
    }
}
