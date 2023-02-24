package AC2_Course.Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


//@@ use visited map prevent save same point
public class A844 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/ACWING/Graph/A844Data.txt"));

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] maze = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        //迷宫map
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

        int[] dirX = new int[]{1, -1, 0, 0};
        int[] dirY = new int[]{0, 0, 1, -1};

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, null));
        visited[0][0] = true;
        int size = 1;
        int count = 0;
        boolean found = false;
        Pair end = null;
        while (size > 0) {
            Pair p = q.poll();
            if (p.i == n - 1 && p.j == m - 1) {
                end = p;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int i1 = p.i + dirX[i];
                int j1 = p.j + dirY[i];
                if (i1 >= 0 && i1 < n && j1 >= 0 && j1 < m && maze[i1][j1] == 0 && !visited[i1][j1]) {
                    Pair curr = new Pair(i1, j1, p);
                    q.add(curr);

                    //! don't forget !
                    visited[i1][j1] = true;
                }
            }

            size--;
            if (size == 0) {
                size = q.size();
                count++;
            }
        }
        System.out.println(count);
        while (end != null) {
            System.out.println(end.i + " - " + end.j);
            end = end.pre;
        }
    }

    static class Pair {
        int i;
        int j;
        Pair pre;

        public Pair(int i, int j, Pair pre) {
            this.i = i;
            this.j = j;
            this.pre = pre;
        }
    }
}
