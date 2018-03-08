package tree;

import java.util.*;

public class _1761 {
    static int[][] dis;
    static boolean[] visited;
    static int[] level;
    static int[] parent;


    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        dis = new int[input + 1][input + 1];
        visited = new boolean[input + 1];
        level = new int[input + 1];
        parent = new int[input + 1];

        while (input > 1) {
            input--;
            int n1 = scan.nextInt();
            int n2 = scan.nextInt();
            int d = scan.nextInt();
            dis[n1][n2] = dis[n2][n1] = d;
        }

        createMap();

        int cmd = scan.nextInt();
        while (cmd > 0) {
            cmd--;
            int n1 = scan.nextInt();
            int n2 = scan.nextInt();
            System.out.println(findRoot(n1, n2));
        }
    }

    private static void createMap() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        level[1] = 1;
        visited[1] = true;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int i = 1; i < visited.length; i++) {
                if (dis[node][i] > 0 && !visited[i]) {
                    level[i] = level[node] + 1;
                    parent[i] = node;
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }

    private static int findRoot(int n1, int n2) {
        int distance = 0;

        if (level[n1] < level[n2]) {
            int temp = n1;
            n1 = n2;
            n2 = temp;
        }
        while (level[n1] > level[n2]) {
            distance += dis[n1][parent[n1]];
            n1 = parent[n1];
        }
        while (n1 != n2) {
            distance += dis[n1][parent[n1]];
            distance += dis[n2][parent[n2]];
            n1 = parent[n1];
            n2 = parent[n2];
        }
        return distance;
    }


}
