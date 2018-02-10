package DP;

import java.util.Scanner;

public class _1495 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        int start = scan.nextInt();
        int max = scan.nextInt();
        int v[] = new int[count + 1];
        boolean d[][] = new boolean[count + 1][max+1];
        boolean c[][] = new boolean[count + 1][max+1];
        for (int i = 1; i <= count; i++) {
            v[i] = scan.nextInt();
        }

        go(start,1,count,max,v,c,d);
        int maxIndex = -1;
        for(int i=max;i>=0;i--){
            if(d[count][i]==true){
                maxIndex=i;
                break;
            }
        }
        System.out.println(maxIndex);


    }

    static void go(int vNow, int cNow, int count, int max, int[] v, boolean[][] c, boolean[][] d) {

        if (cNow > count) return;

        if (vNow + v[cNow] <= max) {
            if (!c[cNow][vNow + v[cNow]]) {
                c[cNow][vNow + v[cNow]] = true;
                d[cNow][vNow + v[cNow]] = true;
                go(vNow + v[cNow], cNow + 1, count, max, v, c, d);
            }
        }

        if (vNow - v[cNow] >= 0) {
            if (!c[cNow][vNow - v[cNow]]) {
                c[cNow][vNow - v[cNow]] = true;
                d[cNow][vNow - v[cNow]] = true;
                go(vNow - v[cNow], cNow + 1, count, max, v, c, d);
            }
        }
    }
}
