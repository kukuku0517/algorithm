package simulation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _13459 {
    static char[][] map;

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        map = new char[row][col];
        Node red = null, blue = null, out = null;
        for (int i = 0; i < row; i++) {
            String s = scanner.next();
            for (int j = 0; j < col; j++) {
                char c = s.charAt(j);
                map[i][j] = c;
                String temp = String.valueOf(c);
                if (!temp.equals("#")) {
                    if (String.valueOf(c).equals("R")) {
                        red = new Node(i, j);
                    } else if (String.valueOf(c).equals("B")) {
                        blue = new Node(i, j);
                    } else if (String.valueOf(c).equals("R")) {
                        out = new Node(i, j);
                    }
                }
            }


        }
        Queue<State> q = new LinkedList<>();
        q.offer(new State(red, blue));
        for (int i = 0; i < 10; i++) {
            State s = q.poll();
            for (int j = 0; j < 4; j++) {
                Node b = moveToDir(s.red,dx[j],dy[j]);
                if (b.equals(out)) continue;
                Node r = new Node(s.red.x + dx[j], s.red.y + dy[j]);
                State newS = new State(r, b);
                q.offer(newS);
            }
        }
    }


    static Node moveToDir(Node node, int dx, int dy) {
        while (map[node.x+dx][node.y+dy]!='#'){
            node.x+=dx;
            node.y+=dy;
        }
        return node;
    }

    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};

    static class State {
        Node red, blue;

        public State(Node red, Node blue) {
            this.red = red;
            this.blue = blue;
        }
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Node obj) {
            if (this.x == obj.x && this.y == obj.y) return true;
            return false;
        }
    }
}
