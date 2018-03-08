package simulation;

import java.util.Arrays;
import java.util.Scanner;

public class _5214 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int nodes = scan.nextInt();
        int links = scan.nextInt();
        int tubes = scan.nextInt();

        int[][] map = new int[nodes + 1][nodes + 1];
        for(int[] a:map){
            Arrays.fill(a,Integer.MAX_VALUE);
        }
        for(int i=0;i<nodes+1;i++){
            map[i][i]=0;
        }

        int[] temp = new int[links];

        for (int i = 0; i < tubes; i++) {
            for (int j = 0; j < links; j++) {
                temp[j] = scan.nextInt();
            }
            for (int j = 0; j < links; j++) {
                for (int k = 0; k < links; k++) {
                    if (j != k) {
                        map[temp[j]][temp[k]] = 1;
                    }
                }
            }
        }

        for (int i = 1; i <= nodes; i++) { //경유
            for (int j = 1; j <= nodes; j++) { //출발
                for (int k = 1; k <= nodes; k++) { //도착
                    if(i!=j && j!=k && i!=k
                            && map[j][i]!=Integer.MAX_VALUE
                            && map[i][k]!=Integer.MAX_VALUE){
                        map[j][k]=Math.min(map[j][k],map[j][i]+map[i][k]);
                    }
                }
            }
        }


        if(map[1][nodes]!=Integer.MAX_VALUE){
            System.out.println(map[1][nodes]+1);
        }else{
            System.out.println(-1);
        }

    }

}