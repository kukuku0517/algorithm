package simulation;

import java.util.Scanner;

public class _13459_bitmask {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int row = scan.nextInt();
        int col = scan.nextInt();
        char[][] map = new char[row][col];
        String start="00000000";
        for (int i = 0; i < row; i++) {
            String s = scan.next();
            for (int j = 0; j < col; j++) {
                char c = s.charAt(j);
                map[i][j] = c;
                if(c=='R'){
                    map[i][j]='.';
//                    start.charAt(0)=(char)String.valueOf(i);
                }else if (c=='B'){

                    map[i][j]='.';
                }else if (c=='O'){

                }
            }
        }
    }


}
