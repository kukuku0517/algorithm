package DS;

import java.util.Scanner;
import java.util.Stack;

public class _6549 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int count = scan.nextInt();
            if (count == 0) break;
            int[] list = new int[count];
            for (int i = 0; i < count; i++) {
                list[i] = scan.nextInt();
            }

            int max = 0;
            Stack<Node> s = new Stack<>();

            for (int i = 0; i < count; i++) {
                while (!s.isEmpty() && s.peek().h > list[i]) {
                    Node temp = s.pop();
                    int width = i;
                    if (!s.isEmpty()) width = i - temp.i - 1;
                    System.out.printf("(%d,%d) * %d\n", temp.i - width + 1, temp.i, temp.h);
                    max = Math.max(width * temp.h, max);
                }
                s.push(new Node(list[i], i));
            }

            while (!s.isEmpty()) {
                Node temp = s.pop();
                int width = count;
                if (!s.isEmpty()) width = count - s.peek().i - 1;
                max = Math.max(width * temp.h, max);
            }
            System.out.println(max);
        }
    }

    static class Node {
        int h;
        int i;

        Node(int h, int i) {
            this.h = h;
            this.i = i;
        }
    }
}
