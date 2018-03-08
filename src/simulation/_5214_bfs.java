package simulation;

import java.util.*;

public class _5214_bfs {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int nodes = scan.nextInt();
        int links = scan.nextInt();
        int tubes = scan.nextInt();

        HashMap<Integer, Node> list = new HashMap<>();

        int[] temp = new int[links];
        for (int i = 0; i < tubes; i++) {
            for (int j = 0; j < links; j++) {
                temp[j] = scan.nextInt();
            }
            for (int j = 0; j < links; j++) {
                for (int k = 0; k < links; k++) {
                    if (j != k) {
                        Node n1 = getFromList(list, temp[j]);
                        Node n2 = getFromList(list, temp[k]);
                        n1.add(n2);
                        n2.add(n1);
                    }
                }
            }
        }

        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[nodes + 1];
        Node start = getFromList(list, 1);
        start.count = 1;
        q.offer(start);
        while (!q.isEmpty()) {
            Node parent = q.poll();
            if(parent.value==nodes)break;
            visited[parent.value] = true;
            for (Node child : parent.near) {
                if (!visited[child.value]) {
                    child.count = parent.count + 1;
                    visited[child.value] = true;
                    q.offer(child);
                }
            }
        }


        System.out.println(getFromList(list, nodes).count);
    }



    static Node getFromList(HashMap<Integer, Node> list, int key) {
        if (list.containsKey(key)) {
            return list.get(key);
        } else {
            Node newNode = new Node(key);
            list.put(key, newNode);
            return newNode;
        }
    }

    static class Node {
        int value;
        int count;
        HashSet<Node> near = new HashSet<>();

        Node(int value) {
            this.value = value;
        }

        void add(Node node) {
            near.add(node);
        }

    }
}
