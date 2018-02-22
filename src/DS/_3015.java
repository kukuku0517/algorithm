package DS;

import java.util.Scanner;
import java.util.Stack;

public class _3015 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        int[] list = new int[count];
        for (int i = 0; i < count; i++) {
            list[i] = scan.nextInt();
        }
        Stack<Node> stack = new Stack<>();
        long answer = 0;
        for (int i = 0; i < count; i++) {
            Node temp = new Node(list[i], 1);
            while (!stack.isEmpty()) {
                if (stack.peek().h <= list[i]) {
                    answer += stack.peek().c;
                    if (stack.peek().h == list[i]) {
                        temp.c += stack.peek().c;
                    }
                    stack.pop();
                } else {
                    break;
                }
            }
            if (!stack.isEmpty()) answer++;
            stack.push(temp);

        }
        System.out.println(answer);
    }

    static class Node {
        int h;
        int c;

        Node(int h, int c) {
            this.h = h;
            this.c = c;
        }
    }
}
