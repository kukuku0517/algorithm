package DS;

import java.util.Scanner;

public class _11723 {
    static int set = 0;

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int cmds = scan.nextInt();
        String cmd;
        StringBuilder builder = new StringBuilder();
        while (cmds > 0) {
            cmds--;
            cmd = scan.next();
            switch (cmd) {
                case "all":
                    set = (1 << 21) - 1;
                    break;
                case "empty":
                    set = 0;
                    break;
                case "add":
                    set = set + (1 << scan.nextInt());
                    break;
                case "remove":
                    set = set - (1 << scan.nextInt());
                    break;
                case "check":
                    int temp = set & (1 << scan.nextInt());
                    if (temp == 0) builder.append("0\n");
                    else  builder.append("1\n");
                    break;
                case "toggle":
                    set = set ^ (1 << scan.nextInt());
                    break;
            }
        }
        System.out.println(builder.toString());
    }


}
