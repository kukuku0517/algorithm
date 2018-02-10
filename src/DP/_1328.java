package DP;

import java.util.Scanner;

public class _1328 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int total = scan.nextInt();
        int left = scan.nextInt();
        int right = scan.nextInt();

        long d[][][] = new long[total + 1][left + 1][right + 1];

        //int는 -2147483648 ~ 2,147,483,647.

        d[1][1][1] = 1L; //결국 전체 1부터 total까지, left, right를 내림차순으로 하나씩 더해가는것
        for (int i = 2; i <= total; i++) {
            for (int j = 1; j <= left; j++) {
                for (int k = 1; k <= right; k++) {
                    d[i][j][k]
                            = d[i - 1][j - 1][k] //왼쪽에 하나 더하기. left에 하나 더하면서, total+1, left +1을 하면 현재 값이 됨.
                            + d[i - 1][j][k - 1] //오른쪽에 하나 더하기. right에 하나 더하면서, total+1, right +1을 하면 현재 값이 됨.
                            + d[i - 1][j][k] * (i - 2); // 사이에 하나 더하기. total-1 사이사이에 하나씩 더하면 left,right는 그대로 유지.
                    d[i][j][k] %= 1000000007L;
                }
            }
        }
        System.out.println(d[total][left][right]);
    }
}
