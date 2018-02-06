package DP;

import java.util.Scanner;

public class _11048 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int row = scan.nextInt()+1,col =scan.nextInt()+1;
		int[][] map = new int [row][col];
		int[][] result = new int[row][col];
		for(int i=1;i<row;i++){
			for(int j=1;j<col;j++){
					map[i][j]=scan.nextInt();
				
			}
		}
		for(int i=1;i<row;i++){
			for(int j=1;j<col;j++){
				result[i][j]=map[i][j]+Math.max(result[i-1][j],result[i][j-1]);
			}
		}
		
		System.out.println(result[row-1][col-1]);
	}

}
