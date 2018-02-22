package DS;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class _4195 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();


        for (int i = 0; i < count; i++) {
            HashMap<String, Integer> counts = new HashMap<>();
            HashMap<String, String> root = new HashMap<>();

            int input = scan.nextInt();
            int max = -1;
            for (int j = 0; j < input; j++) {
                String x = scan.next();
                String y = scan.next();
                if (!root.containsKey(x)) {
                    root.put(x, x);
                    counts.put(x, 1);
                }
                if (!root.containsKey(y)) {
                    root.put(y, y);
                    counts.put(y, 1);
                }
                int temp = union(counts, root, x, y);
                max = Math.max(temp,max);
                System.out.println(max);
            }
        }
    }

    static int union(HashMap<String, Integer> counts,
                      HashMap<String, String> root, String x, String y) {
        x = find(root, x);
        y = find(root, y);
        if (x != y) {
            int temp = counts.get(x) + counts.get(y);
            counts.put(x, temp);
            root.put(y, x);
            return temp;
        }
        return -1;
    }

    static String find(HashMap<String, String> root, String x) {
        if (root.get(x) == x) {
            return x;
        } else {
            String temp = find(root, root.get(x));
            root.put(x, temp);
            return temp;
        }
    }
}
