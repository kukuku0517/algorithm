package DP;

import java.util.Scanner;

public class _11049 {

    public static void main(String a[]) {
        Scanner s = new Scanner(System.in);
        int c = s.nextInt();
        int mat[][] = new int[c][2];
        for (int i = 0; i < c; i++) {
            mat[i][0] = s.nextInt();
            mat[i][1] = s.nextInt();
        }
        int d[][] = new int[c][c];
        System.out.println(go(mat, d, 0, c - 1));

    }


    static int go(int mat[][], int d[][], int x, int y) { // x번째 부터 y번째 까지의 곱연산
        if (d[x][y] > 0) return d[x][y]; //있을땐 값 return
        if (x == y) return 0; //1개일땐 0
        if (x + 1 == y) return mat[x][0] * mat[x][1] * mat[y][1]; //2개일땐 곱연산 직접

        for (int k = x; k < y; k++) { //x,y사이에서 각각 끊어줌. 사이사이 끊은것마다 go call
            int t1 = go(mat, d, x, k);
            int t2 = go(mat, d, k + 1, y);
            int t3 = mat[x][0] * mat[k][1] * mat[y][1]; //k번째에서 끊는다는것은 x~k / k+1~y가 되는것
            if (d[x][y] == 0 || d[x][y] > t1 + t2 + t3) {
                d[x][y] = t1 + t2 + t3;
            }
        }
        return d[x][y];
    }
}
