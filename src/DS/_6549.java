package DS;

import java.util.Scanner;
import java.util.Stack;

public class _6549 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int count = scan.nextInt();
            int[] list = new int[count];
            for (int i = 0; i < count; i++) {
                list[i] = scan.nextInt();
            }

            int max = 0;
            Stack<Integer> s = new Stack<>();
            for (int i = 0; i < count; i++) {
                    int c = 1;
                    while (!s.isEmpty() && s.peek() > list[i]) {
                        int temp = s.pop();
//                        System.out.printf("%d * %d = %d\n",temp,c,temp*c);
                        max = Math.max(c * temp, max);
//                        System.out.printf("max : %d \n",max);
                        c++;
                    }
//                    System.out.printf("push %dth %d\n",i,list[i]);
                    s.push(list[i]);

            }

            int c = 1;
            while (!s.isEmpty()) {
                int temp = s.pop();
                max = Math.max(c * temp, max);
                c++;
            }
            System.out.println(max);


        }
    }

}
