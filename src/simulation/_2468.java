package simulation;

import DP.PrintUtil;

import java.util.*;

public class _2468 {
    public static void main(String a[]) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int[][] map = new int[size][size];
        int currentLevel = Integer.MAX_VALUE;
        int totalWater = size*size;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = scan.nextInt();
                currentLevel = Math.min(currentLevel, map[i][j]);
            }
        }

        totalWater = fillWater(totalWater, size, map, currentLevel);
        int max = 1;
        while (size!=0 && currentLevel <= 100) {
            int count = 0;
            boolean[][] visited = new boolean[size][size];
            Queue<Point> sq = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (map[i][j] != -1 && !visited[i][j]) {
                        count++;
//                        System.out.printf("[%d]start : [%d,%d]\n", count, i, j);
                        sq.offer(new Point(i, j, 0, -1));
                        visited[i][j] = true;
                        while (!sq.isEmpty()) {
                            Point sp = sq.poll();
                            for (int k = 0; k < 4; k++) {
                                int nx = sp.x + dx[k], ny = sp.y + dy[k];
                                if (nx < 0 || ny < 0 || nx >= size || ny >= size) continue;
                                if (visited[nx][ny]) continue;
                                visited[nx][ny] = true;
                                if (map[nx][ny] == -1) continue;
//                                System.out.printf("[%d][%d,%d] + [%d,%d]\n", count, i, j, nx, ny);
                                sq.offer(new Point(nx, ny, 0, -1));

                            }
                        }
                    }
                }
            }
            max = Math.max(max, count);
            currentLevel++;
            totalWater = fillWater(totalWater,size,map,currentLevel);

        }
        System.out.println(max);

    }

    private static int fillWater(int totalWater, int size, int[][] map, int currentLevel) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == currentLevel) {
                    map[i][j] = -1;
                    totalWater--;
                }
            }
        }
        return totalWater;
    }

    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};

    static class Point {
        int x, y, level, type;

        public Point(int x, int y, int level, int type) {
            this.x = x;
            this.y = y;
            this.level = level;
            this.type = type;
        }
    }
}
