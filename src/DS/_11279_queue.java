package DS;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class _11279_queue {

    static PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        while (count > 0) {
            count--;
            int item = scan.nextInt();
            if (item == 0) {
                if (heap.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(heap.poll());
                }
            } else {
                heap.offer(item);
            }
        }
    }

}
