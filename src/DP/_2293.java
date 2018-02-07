package DP;

import java.util.Scanner;

public class _2293 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int type = scan.nextInt();
        int total = scan.nextInt();
        int[] val = new int[type];
        for (int i = 0; i < type; i++) {
            val[i] = scan.nextInt();
        }

// 각 case 에서 해당 type이 무조건하나씩 추가되는 방식으로 풀어냄
//        for(int i=0;i<type;i++){
//            for(int j=0;j<total+1;j++){
//                if(val[i]==j){
//                    cases[i][j]=1;
//                }else if(val[i]>j){
//                    cases[i][j]=0;
//                }else{
//                    for(int k=0;k<=i;k++){
//                        cases[i][j]+= cases[k][j-val[i]];
//                    }
//                }
//            }
//        }


        /**
         * 각 case는
         * 현재 type 사용 : total - type의 가치 를, 현재 type을 사용해서 만든 케이스 cases[i][j-val[i]]
         * 현재 type 미사용 : total을 현재 이전 type의 경우로 만든 케이스 cases[i-1][j]
         * **/

        int[][] cases = new int[type + 1][total + 1];
        cases[0][0] = 1;
        for (int i = 1; i < type + 1; i++) {
            for (int j = 0; j < total + 1; j++) {
                cases[i][j] = cases[i - 1][j];
                if (j - val[i - 1] >= 0) {
                    cases[i][j] += cases[i][j - val[i - 1]];
                }
            }
        }

        System.out.println(cases[type][total]);

    }
}
