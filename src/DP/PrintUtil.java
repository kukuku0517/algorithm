package DP;

public class PrintUtil {
    public static void print2D(int[][] a){
        for(int i[]:a){
            for(int j:i){
                System.out.printf("%2d ",j);
            }
            System.out.println();
        }
    }

    public static void print1D(int[] a){

        for(int j:a){
            System.out.printf("%d ",j);
        }
        System.out.println();
    } public static void print1D(boolean[] a){

        for(boolean j:a){
            System.out.printf("%s ",String.valueOf(j));
        }
        System.out.println();
    }


}
