package DS;

import DP.PrintUtil;

import java.util.Scanner;

public class _1717 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int max = scan.nextInt();
        int count = scan.nextInt();
        int[] root = new int[max+1];
        for(int i=0;i<=max;i++){
            root[i]=i;
        }
        while (count > 0) {
            count--;
            int form = scan.nextInt();
            int x = scan.nextInt();
            int y = scan.nextInt();
            if (form == 0) {
                union(root, x, y);
            } else {
                String ans;
                if (find(root, x) == find(root, y)) {
                    ans = "YES";
                } else {
                    ans = "NO";
                }
                System.out.println(ans);
            }
            PrintUtil.print1D(root);
        }
    }

    static void union(int[] root, int x, int y) {
        x = find(root, x);
        y = find(root, y);
        root[y] = x;

    }

    static int find(int[] root, int x) {
        if (root[x] == x) {
            return x;
        } else {
            return root[x] = find(root, root[x]);
        }
    }
}
