package DP;

import java.util.Scanner;
import java.util.Stack;

public class _1520 {

    public static void main(String a[]) {
        Scanner scan = new Scanner(System.in);
        int row = scan.nextInt(), col = scan.nextInt();
        Node maze[][];
        maze = new Node[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                maze[i][j] = new Node(scan.nextInt(), i, j,row,col);
            }
        }
//        PrintUtil.print2D(maze);

        int count = 0;
        Stack<Node> s = new Stack<>();
        s.push(maze[0][0]);
        while (!s.isEmpty()) {
            Node now = s.pop();
            if(now.val==maze[row-1][col-1].val){
                count++;
                continue;
            }
            if(now.hasTop() && now.val>maze[now.row-1][now.col].val){
                s.push(maze[now.row-1][now.col]);
            }
            if(now.hasBot() && now.val>maze[now.row+1][now.col].val){
                s.push(maze[now.row+1][now.col]);
            }
            if(now.hasLeft() && now.val>maze[now.row][now.col-1].val){
                s.push(maze[now.row][now.col-1]);
            }
            if(now.hasRight()&& now.val>maze[now.row][now.col+1].val){
                s.push(maze[now.row][now.col+1]);
            }

        }
        System.out.println(count);

    }


}

class Node {
    int val;
    int row;
    int col;
    int rowSize, colSize;

    Node(int val, int row, int col, int rowSize, int colSize) {
        this.val = val;
        this.row = row;
        this.col = col;
        this.rowSize=rowSize;
        this.colSize=colSize;
    }

    boolean hasTop(){
        if(row>0)return true;
        return false;
    }

    boolean hasBot(){
        if(row<rowSize-1)return true;
        return false;
    }

    boolean hasLeft(){
        if(col>0)return true;
        return false;
    }

    boolean hasRight(){
        if(col<colSize-1)return true;
        return false;
    }


}