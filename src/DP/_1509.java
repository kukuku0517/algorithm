package DP;

import java.util.Scanner;

public class _1509 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String phrase = scan.nextLine().trim();
        int n = phrase.length();
        boolean[][] c = new boolean[n][n];

        /** 펠린드롬 미리 구하기
         * 문자 1개면 true
         * 문자 2개, 같으면 true
         * 문자 3~n개로 가면서 사이 문자열에 true면 true
         * **/
        for (int i = 0; i < n; i++) {
            c[i][i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            if (phrase.charAt(i) == phrase.charAt(i + 1)) {
                c[i][i + 1] = true;
            }
        }

        for (int k = 2; k < n; k++) {
            for (int i = 0; i < n - k; i++) {
                int j = i + k;
                c[i][j] = (c[i + 1][j - 1] && (phrase.charAt(i) == phrase.charAt(j)));
            }
        }

        //?????????????????????????

        int[] d = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            d[i] = -1;
            for (int j = 1; j <= i; j++) {
                if (c[j - 1][i - 1]) {
                    if (d[i] == -1 || d[i] > d[j - 1] + 1) {
                        d[i] = d[j - 1] + 1;
                    }
                }
            }
        }

        System.out.println(d[n]);
    }

}
