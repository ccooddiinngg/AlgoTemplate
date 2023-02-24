package AC2_Course.UnionFind;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//837. 连通块中点的数量
public class A837 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/ACWING/UnionFind/A837Data.txt"));
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] uf = new int[n + 1];
        int[] size = new int[n + 1];
        for (int i = 0; i < uf.length; i++) {
            uf[i] = i;
            size[i] = 1;
        }
        for (int i = 0; i < q; i++) {
            String op = sc.next();

            switch (op) {
                case "Q1" -> {
                    int x1 = sc.nextInt();
                    int x2 = sc.nextInt();
                    if (isSameSet(uf, x1, x2)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No");
                    }
                    break;
                }
                case "C" -> {
                    int x1 = sc.nextInt();
                    int x2 = sc.nextInt();
                    union(uf, size, x1, x2);
                    break;
                }
                case "Q2" -> {
                    int x = sc.nextInt();
                    int s = size[findP(uf, x)];
                    System.out.println(s);
                }
            }
        }
    }

    public static int findP(int[] uf, int x) {
        if (uf[x] != x) {
            uf[x] = findP(uf, uf[x]);
        }
        return uf[x];
    }

    public static void union(int[] uf, int[] size, int x1, int x2) {
        int p1 = findP(uf, x1);
        int p2 = findP(uf, x2);
        if (p1 != p2) {
            uf[p1] = p2;
            size[p2] += size[p1];
        }
    }

    public static boolean isSameSet(int[] uf, int x1, int x2) {
        return findP(uf, x1) == findP(uf, x2);
    }

}
