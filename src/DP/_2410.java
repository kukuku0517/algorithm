package DP;

import java.util.Arrays;
import java.util.Scanner;

public class _2410 {
    public static void main(String a[]) {
        long mod = 1000000;
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int powOfTwo = 1;
        long d[] = new long[num + 1];
        d[0] = 1;

        while (powOfTwo <= num) {

            for (int i = powOfTwo; i < num + 1; i++) {
                d[i] += d[i - powOfTwo];
                d[i] %= mod;

            }
            powOfTwo *= 2;
        }
        System.out.println(d[num]);
    }
}
