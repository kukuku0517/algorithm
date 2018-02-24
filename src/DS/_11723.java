package DS;

import java.util.Scanner;

public class _11723 {
    static int set = 0;

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int cmds = scan.nextInt();
        String cmd;
        int item;
        while (cmds > 0) {
            cmds--;
            cmd = scan.next();
            switch (cmd) {
                case "all":
                    all();
                    break;
                case "empty":
                    empty();
                    break;
                case "add":
                    item = scan.nextInt();
                    add(item);
                    break;
                case "remove":
                    item = scan.nextInt();
                    remove(item);
                    break;
                case "check":
                    item = scan.nextInt();
                    check(item);
                    break;
                case "toggle":
                    item = scan.nextInt();
                    toggle(item);
                    break;
            }
        }
    }

    static void add(int x) {
        set = set + (1 << x);
    }

    static void remove(int x) {
        set = set - (1 << x);
    }

    static void check(int x) {
        int temp = set & (1 << x);
        if (temp > 0) System.out.println(1);
        else System.out.println(0);
    }

    static void toggle(int x) {
        set = set ^ (1 << x);
    }

    static void all() {
        set = (1<<20)-1;
    }

    static void empty() {
        set = 0;
    }
}
