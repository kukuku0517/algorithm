package DS;

import java.util.Scanner;
import java.util.Stack;

public class _9935 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String origin = scan.nextLine();
        String bomb = scan.nextLine();

        Stack<Node> result = new Stack<>();
        boolean erase[] = new boolean[origin.length()];

        if (bomb.length() != 1) {
            for (int i = 0; i < origin.length(); i++) {
                int temp = getIndex(origin.charAt(i), bomb);
                if (temp == 0) {
                    result.push(new Node(i, 0));
                } else {
                    if (!result.isEmpty()) {
                        int n = result.peek().bomb;
                        if (n + 1 == temp) {
                            result.push(new Node(i, n + 1));
                            if (temp == bomb.length() - 1) {
                                int count = bomb.length();
                                while (count > 0) {
                                    int index = result.pop().origin;
                                    erase[index]=true;
                                    count--;
                                }
                            }
                        } else {
                            result.clear();
                        }
                    }
                }
            }
        } else {
            for (int i = 0; i < origin.length(); i++) {
                if (origin.charAt(i) == bomb.charAt(0)) {
                    erase[i] = true;
                }
            }
        }


        boolean empty = true;
        for (int i = 0; i < origin.length(); i++) {
            if (!erase[i]) {
                System.out.print(origin.charAt(i));
                empty = false;
            }
        }
        if (empty) {
            System.out.println("FRULA");
        }
    }

    static int getIndex(char c, String bomb) {
        for (int i = 0; i < bomb.length(); i++) {
            if (c == bomb.charAt(i)) return i;
        }
        return -1;
    }

    static class Node {
        int origin;
        int bomb;

        Node(int o, int b) {
            this.origin = o;
            this.bomb = b;
        }
    }
}
