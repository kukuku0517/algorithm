package DP;

import java.util.Scanner;

public class _1495 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        int start = scan.nextInt();
        int max = scan.nextInt();
        int v[] = new int[count + 1];
        int d[] = new int[count + 1];
        boolean c[][] = new boolean[count + 1][max + 1];
        for (int i = 1; i <= count; i++) {
            v[i] = scan.nextInt();
        }

        System.out.println(go(start, 1, count, max, v, c, d));


    }

    static int go(int vNow, int cNow, int count, int max, int[] v, boolean[][] c, int[] d) {

        if (cNow > count) return -1;

        int c1 = -1;
        int c2 = -1;

        if (cNow == count) {
            if (vNow + v[cNow] <= max) {
                c1 = vNow + v[cNow];
            }
            if (vNow - v[cNow] >= 0) {
                c2 = vNow - v[cNow];
            }
            d[cNow] = Math.max(d[cNow], Math.max(c1, c2));
            return d[cNow];
        }

        if (vNow + v[cNow] <= max) {
            if (!c[cNow][vNow + v[cNow]]) {
                c[cNow][vNow + v[cNow]] = true;
                d[cNow] = vNow + v[cNow];
                c1 = go(vNow + v[cNow], cNow + 1, count, max, v, c, d);
            }
        }

        if (vNow - v[cNow] >= 0) {
            if (!c[cNow][vNow - v[cNow]]) {
                c[cNow][vNow - v[cNow]] = true;
                d[cNow] = vNow - v[cNow];
                c2 = go(vNow - v[cNow], cNow + 1, count, max, v, c, d);
            }
        }
        return Math.max(c1, c2);
    }
}
