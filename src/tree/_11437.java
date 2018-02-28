package tree;

import java.util.*;

public class _11437 {
    static Node[] map;

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        map = new Node[count + 1];
        Node root = new Node(1);
        root.checked=true;
        map[1] = root;

        while (count > 1) {
            count--;
            int node1 = scan.nextInt();
            int node2 = scan.nextInt();
            add(node1, node2);
        }

        join();

        int findCount = scan.nextInt();
        while (findCount > 0) {
            findCount--;
            int node1 = scan.nextInt();
            int node2 = scan.nextInt();
            System.out.println(findRoot(node1, node2));
        }
    }

    static int findRoot(int num1, int num2) {
        Node n1 = map[num1];
        Node n2 = map[num2];

        if (n1.level > n2.level) {
//            System.out.printf("%d[%d]>%d[%d]\n",n1.value,n1.level,n2.value,n2.level);
            while (n1.level > n2.level) {
//                System.out.printf("%d[%d]->%d[%d]\n",n1.value,n1.level,n1.parent.value,n1.parent.level);
                n1 = n1.parent;
            }
        } else if (n1.level < n2.level) {
//            System.out.printf("%d[%d]<%d[%d]\n",n1.value,n1.level,n2.value,n2.level);
            while (n1.level < n2.level) {
//                System.out.printf("%d[%d]->%d[%d]\n",n2.value,n2.level,n2.parent.value,n2.parent.level);
                n2 = n2.parent;
            }
        } else {
//            System.out.printf("%d[%d]=%d[%d]\n",n1.value,n1.level,n2.value,n2.level);
        }

        while (n1 != n2) {
//            System.out.printf("%d[%d]->%d[%d]\n",n1.value,n1.level,n1.parent.value,n1.parent.level);
//            System.out.printf("%d[%d]->%d[%d]\n",n2.value,n2.level,n2.parent.value,n2.parent.level);

            n1 = n1.parent;
            n2 = n2.parent;
        }
        return n1.value;
    }

    static void add(int num1, int num2) {
        if (map[num1] == null)
            map[num1] = new Node(num1);

        if (map[num2] == null)
            map[num2] = new Node(num2);


        map[num1].links.add(map[num2]);
        map[num2].links.add(map[num1]);
    }

    static void join() {
        Queue<Node> q = new LinkedList<>();
        q.add(map[1]);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            for (Node n : temp.links) {
                if (!n.checked) {
                    n.checked=true;
                    n.parent = temp;
                    n.level = temp.level + 1;
                    q.offer(n);
                }
            }
        }
    }

    static class Node {
        int value;
        boolean checked=false;
        int level = 1;
        Node parent = null;
        List<Node> links = new ArrayList<>();

        Node(int val) {
            this.value = val;
        }
    }
}
