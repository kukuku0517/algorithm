package DS;

public class UnionFind {
    public static void main(String args[]) {
        int[] root ={0,1,2,3,4};
        union(root, 0, 1);
        union(root, 2, 3);
        union(root, 2, 4);
        for (int i : root) {
            System.out.printf("%d ", i+1);
        }
    }

    static void union(int[] root, int x, int y) {
        int rootX = find(root, x);
        int rootY = find(root, y);
        root[rootY] = rootX;

    }

    static int find(int[] root, int x) {
        if (root[x] == x) {
            return x;
        } else {
            return root[x] = find(root, root[x]);
        }
    }
}
