package simulation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _3055 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int row = scan.nextInt(), col = scan.nextInt();
        char[][] map = new char[row][col];
        boolean [][] visited = new boolean[row][col];

        Node S=null;
        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            String s = scan.next();
            for (int j = 0; j < col; j++) {
                char c = s.charAt(j);
                map[i][j] = c;
                if (c == 'S') {
                   map[i][j]='.';
                   S=new Node(i,j,0,0);
                }else if (c=='*'){
                    q.offer(new Node(i,j,1,0));
                    visited[i][j]=true;
                }
            }
        }
        q.offer(S);
        boolean finished = false;

        while(!q.isEmpty()&&!finished){
            Node node = q.poll();
//            System.out.printf("[%d][%d,%d][%s]\n",node.count,node.x,node.y,node.type==0?"S":"*");

            for(int i=0;i<4;i++){
                int nx = node.x+dx[i];
                int ny = node.y+dy[i];
                if(nx<0 || ny < 0 || nx>=row || ny>=col)continue;
                if(visited[nx][ny])continue;
                if(map[nx][ny]=='X')continue;

                if(node.type==0){
                    if(map[nx][ny]=='D'){
//                        System.out.printf("[%d,%d]>[%d,%d]:finish\n",node.x,node.y,nx,ny);
                        System.out.println(node.count+1);
                        finished=true;
                        break;
                    }else if(map[nx][ny]=='.'){

//                        System.out.printf("[%d,%d]>[%d,%d]:move\n",node.x,node.y,nx,ny);
                        visited[nx][ny]=true;

                        q.offer(new Node(nx,ny,node.type,node.count+1));
                    }
                }else{
                    if(map[nx][ny]=='.'){
                        visited[nx][ny]=true;

//                        System.out.printf("[%d,%d]>[%d,%d]:fire\n",node.x,node.y,nx,ny);
                        q.offer(new Node(nx,ny,node.type,node.count+1));
                    }
                }
            }
            if(finished)break;
        }

        if(!finished)System.out.println("KAKTUS");

    }
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};


    static class Node {
        int x, y, type, count;

        public Node(int x, int y, int type, int count) {
            this.x = x;
            this.y = y;
            this.type = type;
            this.count = count;
        }
    }
}
