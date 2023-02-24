package AC2_Course.Hash;

public class A841 {


    //@@ "abc..." -> h[a]+P^(n-1) + h[b]+P^(n-2) + h[c]+P^(n-3) ...
    public static void main(String[] args) {
        int N = 100010;
        long[] h = new long[N];
        long[] p = new long[N];
        int P = 131;

        int n = 8;
        int[][] m = {{1, 3, 5, 7}, {1, 3, 6, 8}, {1, 2, 1, 2}};
        String s = "aabbaabb";

        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            p[i] = p[i - 1] * P;
            h[i] = h[i - 1] * P + s.charAt(i - 1);
        }


        for (int i = 0; i < m.length; i++) {
            int l1 = m[i][0];
            int r1 = m[i][1];
            int l2 = m[i][2];
            int r2 = m[i][3];
            long hash1 = h[r1] - h[l1 - 1] * p[r1 - l1 + 1];
            long hash2 = h[r2] - h[l2 - 1] * p[r2 - l2 + 1];
            System.out.println(hash1 == hash2 ? "Yes" : "No");
        }
    }
}
