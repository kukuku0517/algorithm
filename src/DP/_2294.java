package DP;

import java.util.Arrays;
import java.util.Scanner;

public class _2294 {
    public static void main(String a[]) {
        Scanner scan = new Scanner(System.in);
        int type = scan.nextInt();
        int total = scan.nextInt();
        int[] val = new int[type];
        for (int i = 0; i < type; i++) {
            val[i] = scan.nextInt();
        }


        int[] cases = new int[total + 1]; //어짜피 새로 갱신되는거라 1차원가능
        Arrays.fill(cases, -1);
        cases[0] = 0;
        for (int i = 0; i < type; i++) {
            for (int j = 0; j < total + 1; j++) {
                if (j - val[i] >= 0 && cases[j - val[i]] != -1) { //현재 동전 추가 가능한 경우만 갱신
                    if (cases[j] == -1 || cases[j] > cases[j - val[i]]) { //기존값이 없거나, 새로운 값이 더 작은경우
                        cases[j] = cases[j - val[i]] + 1;
                    }
                }

            }
        }

        System.out.println(cases[total]);


    }
}
