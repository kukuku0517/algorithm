package simulation;

import java.util.*;

public class _1194 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int row = scan.nextInt();
        int col = scan.nextInt();
        char[][] map = new char[row][col];
        boolean[][][] visitedWithKeys = new boolean[51][51][1 << 7];


        State state = null;
        for (int i = 0; i < row; i++) {
            String s = scan.next();
            for (int j = 0; j < col; j++) {
                char c = s.charAt(j);
                map[i][j] = c;
                if (c == '0') {
                    state = new State(i, j, 0, 0);
                    visitedWithKeys[i][j][getKey(0, 0)] = true;
                    map[i][j] = '.';
                }
            }
        }

        Queue<State> q = new LinkedList<>();
        q.offer(state);
        boolean hasEscaped = false;
        int count = -1;
        while (!q.isEmpty() && !hasEscaped) {
            State temp = q.poll();
//            System.out.printf("[%d,%d] keys:%d \n", temp.x, temp.y, temp.keys);

            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= row || ny >= col) continue;
                if (visitedWithKeys[nx][ny][temp.keys]) continue;
                visitedWithKeys[nx][ny][temp.keys] = true;
                if (map[nx][ny] == '#') continue;


//                    System.out.printf("[%d,%d]>[%d,%d]\n", temp.x, temp.y, nx, ny);

                char now = map[nx][ny];

                if (now == '1') {
                    hasEscaped = true;
                    count = temp.count + 1;
                    break;
                } else if ('a' <= now && now <= 'f') {
                    int key = now - 'a';
                    int keys = getKey(temp.keys, key);
                    State newState = new State(nx, ny, keys, temp.count + 1);
                    visitedWithKeys[nx][ny][keys] = true;
                    q.offer(newState);
                } else if ('A' <= now && now <= 'F') {
                    int door = now - 'A';
                    if (hasKey(temp.keys, door)) {
//                            System.out.printf("has key : %c\n", now);
                        State newState = new State(nx, ny, temp.keys, temp.count + 1);
                        q.offer(newState);
                    }
                } else {
                    q.offer(new State(nx, ny, temp.keys, temp.count + 1));
                }

            }
        }

        System.out.println(count);


    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class State {
        int x, y;
        int keys;
        int count;

        public State(int x, int y, int keys, int count) {
            this.x = x;
            this.y = y;
            this.keys = keys;
            this.count = count;
        }

    }


    static int getKey(int keys, int newKey) {
        return keys | 1 << newKey;
    }

    static boolean hasKey(int keys, int key) {
        if ((keys & 1 << key) == 0) return false;
        return true;
    }


}
