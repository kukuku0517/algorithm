package DS;

import java.util.HashMap;
import java.util.Scanner;

public class _4195 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();

        for (int i = 0; i < count; i++) {
            HashMap<String, Node> list = new HashMap<>();
            int input = scan.nextInt();
            for (int j = 0; j < input; j++) {
                String x = scan.next();
                String y = scan.next();
                if(!list.containsKey(x)){
                    list.put(x,new Node(1,x));
                }
                if(!list.containsKey(y)){
                    list.put(y,new Node(1,y));
                }

                union(list, x, y);
                System.out.println(list.get(x).count);
            }
        }
    }

    static void union(HashMap<String, Node> list, String x, String y) {
        x = find(list, list.get(x),list.get(x).count);
        y = find(list, list.get(y),list.get(y).count);
        list.get(y).root = list.get(x);

    }

    static String find(HashMap<String, Node> list, Node x, int count) {
        if (list.get(x.name).name == x.name) {
            x.count += count;
            return x.name;
        } else {
//            return root.put(x, find(root, rootCount, root.get(x)));
            x.root = list.get(find(list, x.root, x.count));
            return x.name;
        }
    }

    static class Node {
        Node root;
        int count;
        String name;

        Node(int count, String name) {
            this.count = count;
            this.name = name;
        }
    }


}
