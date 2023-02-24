package Leetcode.ACW_LeetCode;

import java.util.LinkedList;

public class LC71 {

    public String simplifyPath(String path) {
        LinkedList<String> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        String[] strs = path.split("/");
        // System.out.println(Arrays.toString(strs));
        for (int i = 0; i < strs.length; i++) {
            if ("..".equals(strs[i])) {
                if (!q.isEmpty()) q.pollLast();
            }else if (!"".equals(strs[i]) && !".".equals(strs[i])) {
                q.offerLast(strs[i]);
            }
        }
        sb.append("/");
        if (q.isEmpty()) return sb.toString();
        while (!q.isEmpty()) {
            sb.append(q.pollFirst()).append("/");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
