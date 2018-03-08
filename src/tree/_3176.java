package tree;

import java.util.*;

public class _3176 {
    static int[][] dis;
    static boolean[] visited;
    static List<Integer>[] list;
    static int[] level;
    static int[] parent;


    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        dis = new int[input + 1][input + 1];
        visited = new boolean[input + 1];
        level = new int[input + 1];
        parent = new int[input + 1];
        list = new List[input+1];
        for(int i=0;i<input+1;i++){
            list[i]=new ArrayList<>();
        }


        while (input > 1) {
            input--;
            int n1 = scan.nextInt();
            int n2 = scan.nextInt();
            int d = scan.nextInt();
            dis[n1][n2] = dis[n2][n1] = d;
            list[n1].add(n2);
            list[n2].add(n1);
         }

        createMap();

        int cmd = scan.nextInt();
        while (cmd > 0) {
            cmd--;
            int n1 = scan.nextInt();
            int n2 = scan.nextInt();
            findRoot(n1, n2);
        }
    }

    private static void createMap() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        level[1] = 1;
        visited[1] = true;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int i: list[node]) {
                if (!visited[i]) {
                    level[i] = level[node] + 1;
                    parent[i] = node;
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }

    private static void findRoot(int n1, int n2) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        if (level[n1] < level[n2]) {
            int temp = n1;
            n1 = n2;
            n2 = temp;
        }
        while (level[n1] != level[n2]) {
            max = Math.max(max, dis[n1][parent[n1]]);
            min = Math.min(min, dis[n1][parent[n1]]);

            n1 = parent[n1];
        }
        while (n1 != n2) {
            max = Math.max(max, dis[n1][parent[n1]]);
            min = Math.min(min, dis[n1][parent[n1]]);
            max = Math.max(max, dis[n2][parent[n2]]);
            min = Math.min(min, dis[n2][parent[n2]]);
            n1 = parent[n1];
            n2 = parent[n2];
        }

        System.out.printf("%d %d\n", min, max);
    }


}
