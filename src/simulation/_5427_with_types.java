package simulation;

import java.util.*;

public class _5427_with_types {


    static int[][] map;
    static boolean[][] visited;
    static int w, h;
    static Node start;

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        while (cases > 0) {
            cases--;

            w = scan.nextInt();
            h = scan.nextInt();
            map = new int[h][w];
            visited = new boolean[h][w];

            Queue<Node> q = new LinkedList<>();

            for (int i = 0; i < h; i++) {
                String s = scan.next();
                for (int j = 0; j < w; j++) {
                    int item = charToInt(s.charAt(j));
                    if (item == 2) {
                        visited[i][j] = true;
                        start = new Node(i, j, 1, 0);
                        item = 3;
                    } else if (item == 1) {
                        q.offer(new Node(i, j, 1, 1));
                    }
                    map[i][j] = item;
                }
            }

            q.offer(start);

            int path = -1;
            if (isEscaped(start)) {
                path = 1;
            } else {
                while (!q.isEmpty()) {
                    Node temp = q.poll();

                    if (temp.type == 1) {
//                        System.out.printf("fire : [%d](%d,%d)\n", temp.currMoves, temp.x, temp.y);

                        List<Node> list = new ArrayList<>();


                        for (int k = 0; k < 4; k++) {
                            int nx = temp.x + dx[k];
                            int ny = temp.y + dy[k];
                            if (nx >= 0 && nx < h && ny >= 0 && ny < w
                                    && !visited[nx][ny] && map[nx][ny] == 3) {
//                                System.out.printf("(%d,%d)>(%d,%d) : spreading\n", temp.x, temp.y, nx, ny);
                                list.add(new Node(nx, ny, temp.currMoves + 1, temp.type));
                            }
                        }

                        for (Node node : list) {
                            map[node.x][node.y] = 1;
                            visited[node.x][node.y] = true;
                            q.offer(node);

                        }

                    } else {

                        if (isEscaped(temp)) {
                            path = temp.currMoves;
                            break;
                        }

//                        System.out.printf("player : [%d](%d,%d)\n", temp.currMoves, temp.x, temp.y);

                        for (int i = 0; i < 4; i++) {
                            int nx = temp.x + dx[i];
                            int ny = temp.y + dy[i];
                            if (nx >= 0 && nx < h && ny >= 0 && ny < w
                                    && !visited[nx][ny] && map[nx][ny] == 3) {

//                                System.out.printf("(%d,%d)>(%d,%d) : moving to\n", temp.x, temp.y, nx, ny);

                                visited[nx][ny] = true;
                                q.offer(new Node(nx, ny, temp.currMoves + 1, temp.type));
                            }
                        }
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
        if ((node.x == 0 || node.x == h - 1) || (node.y == 0 || node.y == w - 1)) {
            return true;
        }
        return false;
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
        int x, y, currMoves, type;

        public Node(int x, int y, int currMoves, int type) {
            this.x = x;
            this.y = y;
            this.currMoves = currMoves;
            this.type = type;
        }
    }
}
