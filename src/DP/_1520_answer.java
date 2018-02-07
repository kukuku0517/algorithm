package DP;

import java.util.Scanner;


public class _1520_answer {
    static int n, m;
    static int d[][];
    static int maze[][];

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        maze = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maze[i][j] = scan.nextInt();
            }
        }
        d = new int[n][m];
        System.out.println(go(0, 0));
    }

    static int dx[] = new int[]{0, 0, 1, -1};
    static int dy[] = new int[]{1, -1, 0, 0};

    private static int go(int x, int y) {
        System.out.println(maze[x][y]);
        if (x == n - 1 && y == m - 1) return 1;
        if (d[x][y] > 0) return d[x][y];
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = x + dy[k];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (maze[x][y] > maze[nx][ny]) {
                    d[x][y] += go(nx, ny);
                }
            }
        }
        return d[x][y];
    }
}
