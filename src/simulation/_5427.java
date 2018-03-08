package simulation;

import DP.PrintUtil;

import java.util.*;

public class _5427 {

    static int moves;
    static int[][] map;
    static boolean [][] visited;
    static int w, h;

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        while (cases > 0) {
            cases--;
            moves = 0;
            w = scan.nextInt();
            h = scan.nextInt();
            map = new int[h][w];
            visited = new boolean[h][w];
            Node start = null;
            for (int i = 0; i < h; i++) {
                String s = scan.next();
                for (int j = 0; j < w; j++) {
                    int item = charToInt(s.charAt(j));
                    if (item == 2) {
                        start = new Node(i, j, 1);
                        item = 3;
                    }
                    map[i][j] = item;

                }
            }

            Queue<Node> q = new LinkedList<>();
            q.offer(start);
            int path = -1;
            while (!q.isEmpty()) {
                Node temp = q.poll();
                visited[temp.x][temp.y]=true;
//                System.out.printf("[%d](%d,%d)\n", temp.currMoves, temp.x, temp.y);

                if (isEscaped(temp)) {
                    path = temp.currMoves;
                    break;
                }
                if (moves != temp.currMoves) {

//                    System.out.printf("[%d]>[%d] : start spread \n", moves, temp.currMoves);
                    moves = temp.currMoves;
                    spread();
//                    PrintUtil.print2D(map);
                }

                for (int i = 0; i < 4; i++) {
                    int nx = temp.x + dx[i];
                    int ny = temp.y + dy[i];
                    if (nx >= 0 && nx < h && ny >= 0 && ny < w
                            && visited[nx][ny]==false && map[nx][ny] == 3) {

//                        System.out.printf("(%d,%d)>(%d,%d) : moving to\n", temp.x, temp.y, nx, ny);
                        q.offer(new Node(nx, ny, moves + 1));
                    }
                }
            }
//            System.out.println("*********************Answer**************************");

            if (path != -1) {
                System.out.println(path);
            } else {
                System.out.println("IMPOSSIBLE");
            }

        }
    }

    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    static boolean isEscaped(Node node) {
        if ((node.x == 0 || node.x == h - 1) || (node.y == 0 | node.y == w - 1)) {
            return true;
        }
        return false;
    }

    static void spread() {
        List<Node> list = new ArrayList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < h && ny >= 0 && ny < w
                                && map[nx][ny] == 3) {
//                            System.out.printf("(%d,%d)>(%d,%d) : spreading\n", i, j, nx, ny);
                            list.add(new Node(nx, ny, -1));
                        }
                    }
                }
            }
        }


        for (Node node : list) {
            map[node.x][node.y] = 1;
        }
    }

    static int charToInt(char c) {
        String temp = String.valueOf(c);
        switch (temp) {
            case "#":
                return 0;
            case "*":
                return 1;
            case "@":
                return 2;
            case ".":
                return 3;
        }
        return -1;
    }

    static class Node {
        int x, y, currMoves;

        public Node(int x, int y, int currMoves) {
            this.x = x;
            this.y = y;
            this.currMoves = currMoves;
        }
    }
}
