package DP;

import java.util.Scanner;

public class _1720 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        int a[] = new int[31];

        //index -1, -2 case가 있으면 걍 초기화하기...
        a[1] = 1;
        a[2] = 3;

        //동전 조합과 같은 원리
        for (int i = 3; i < len + 1; i++) {
            a[i] = 2 * a[i - 2] + a[i - 1];
        }
        //loop돌릴 필요가... len일경우만 있으면됨
        long b;
        if (len % 2 == 1) { // 짝수개일경우 중심이하
            b = a[(len - 1) / 2];
        } else {  // 홀수개일경우 중심-1은 2*1 타일, 중심-2는 1*2타일, 2*2타일
            b = a[(len / 2) - 1] * 2 + a[len / 2];
        }
        if(len==1 || len ==2){
            System.out.println((int) (a[len]));
        }else{
            System.out.println((int) ((a[len] + b) / 2));
        }

    }
}
