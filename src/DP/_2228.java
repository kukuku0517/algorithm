package DP;

import java.util.Scanner;

public class _2228 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] a = new int[n + 1];
        int[] s = new int[n + 1];
        int[][] d = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = scan.nextInt();
            s[i] = s[i - 1] + a[i];
        }

        boolean[][] c = new boolean[n + 1][m + 1];

        System.out.println(go(a, s, d, c, n, m));

    }

    /**
     * @param n 이 단계에 포함될 숫자의 수. 1~n 까지
     * @param m 이 단계에 배분될 그룹의 개수
     *
     *          n 번째 수가 현재 그룹에 포함될지 안될지의 여부
     *          case 1 : n번째 원소가 포함 안 될 경우
     *              m개의 그룹은 현재 원소를 포함하지 않은 n-1개의 원소들의 최대값과 같다
     *          case 2 : n번째 원소가 포함 될 경우
     *              n번째 원소가 m번째 그룹에 포함되는 경우.
     *              m번째 그룹의 크기가 얼마인지 모르므로, 1~ 현재 주어진 총 수의 개수(n) loop를 돌려 최대값을 찾는다
     *              m번째 그룹이 i부터 시작한다면,
     *              i부터 n번째 원소까지의 합(m번째 그룹) + m-1번째 그룹을 i~n째의 원소를 제외한 숫자합의 최대값
     * **/
    static int go(int[] a, int[] s, int[][] d, boolean[][] c, int n, int m) {
        if (m == 0) return 0;
        if (n <= 0) return -32786*101;
        if (c[n][m]) return d[n][m];
        c[n][m] = true;
        d[n][m] = go(a,s,d,c,n-1,m);

        for (int i = 1; i <= n; i++) {
            d[n][m] = Math.max(d[n][m], go(a, s, d, c, i - 2, m - 1) + s[n] - s[i-1]);
        }
        return d[n][m];

    }

}
