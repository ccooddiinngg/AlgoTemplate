package tag.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        bt(n, 0, 0, "", list);
        return list;
    }


    void bt(int n, int left, int right, String path, List<String> list) {
        if (left + right == 2 * n) {
            list.add(path);
            return;
        }
        if (left < n) {
            bt(n, left + 1, right, path + "(", list);
        }
        if (right < left) {
            bt(n, left, right + 1, path + ")", list);
        }
    }
}
