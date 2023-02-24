package ZuoChengyun.Middle.Day2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Parentheses {

    public static void find(int N, int l, int r, String path, List<String> list) {
        if (path.length() == N) {
            list.add(path);
            return;
        }
        if (l < N / 2) {
            find(N, l + 1, r, path + "(", list);
        }
        if (r < l) {
            find(N, l, r + 1, path + ")", list);
        }
    }

    public static void find2(int N, int index, int left, int right, String path, List<String> list) {
        if (index == N) {
            list.add(path);
            return;
        }
        if (left < N / 2) {
            find2(N, index + 1, left + 1, right, path + '(', list);
        }
        if (right < left) {
            find2(N, index + 1, left, right + 1, path + ')', list);
        }
    }

    @Test
    void test() {
        int N = 6;
        List<String> list = new ArrayList<>();
        find(N, 0, 0, "", list);
        System.out.println(list);

        List<String> list2 = new ArrayList<>();
        find2(N, 0, 0, 0, "", list2);
        System.out.println(list2);
    }
}
