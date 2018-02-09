package DP;

import java.util.Scanner;

public class _2240 {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        int swap = s.nextInt();
        int a[] = new int[count + 1];
        int d[] = new int[count + 1];
        boolean c[][] = new boolean[count + 1][swap + 1];
        int sv[][] = new int[count + 1][swap + 1];
        for (int i = 1; i < count + 1; i++) {
            a[i] = s.nextInt();
            d[i] = d[i - 1] + (2 - a[i]);
        }

        System.out.println(go(a, d, c, sv, count, swap));
    }

    /**
     * @param count 현재까지 지난 시간
     * @param swap 현재까지 이동한 횟수
     *
     *             count동안 swap번 이동했을때 최대 값을 return 한다
     *             이는,
     *             case 1 : count-1 초에 swap번 이동해있는 상태였을때 + count초에 swap위치에 자두유무
     *             case 2 : count-1 초에 swap-1번 이동, count초에 이동하여 swap위치에 자두유무
     *             중 최대값이다.
     *
     *             * 이동 횟수가 0일경우, 현재 count까지 1번나무에서의 자두유무를 모두 더한다
     * **/
    static int go(int a[], int d[], boolean[][] c, int[][] sv, int count, int swap) {
        int temp = (a[count] == (swap % 2) + 1 ? 1 : 0);

        if (count == 0) {
            return (temp);
        }
        if (swap == 0) {
            return d[count];
        }

        if (c[count][swap] == true) {
            return sv[count][swap];
        }
        c[count][swap] = true;


        int t1 = go(a, d, c, sv, count - 1, swap - 1) + (temp);
        int t2 = go(a, d, c, sv, count - 1, swap) + (temp);
        sv[count][swap] = Math.max(t1, t2);
        return sv[count][swap];
    }
}
