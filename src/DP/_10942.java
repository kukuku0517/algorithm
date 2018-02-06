package DP;

import java.util.Scanner;

public class _10942 {
    public static int[][] result;
    static int a[] ;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();
        a = new int[length];
        result = new int[length][length];
        for (int i = 0; i < length; i++) {
            a[i] = scan.nextInt();
        }
        int numOfQuiz = scan.nextInt();
        for (int i = 0; i < numOfQuiz; i++) {
            if (isPenlindromeDynamic( scan.nextInt()-1, scan.nextInt()-1)==1) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    public static int isPenlindromeDynamic( int s, int e) {
        if (result[s][e] != 0) {
            return result[s][e];
        }
        if (s == e) {
            return 1;
        }
        if (s + 1 == e) {
            if (a[s] == a[e]) {
                return 1;
            } else {
                return 2;
            }
        }
        if (a[s] == a[e] ) {
            return result[s][e]=isPenlindromeDynamic(s+1,e-1);
        } else {
            return result[s][e] = 2;
        }
    }

}
