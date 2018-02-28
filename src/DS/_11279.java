package DS;

import java.util.Scanner;

public class _11279 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        Heap heap = new Heap();
        while (count > 0) {
            count--;
            int item = scan.nextInt();
            if (item == 0) {
                System.out.println(heap.pop());
            } else {
                heap.push(item);
            }

        }
    }


    static class Heap {
        int MAX = 100000;
        int last = 0;
        int[] heap = new int[MAX + 1];

        void push(int x) {
            last++;
            int temp = last;
            while (temp > 1) {
                if (x > heap[temp / 2]) {
                    heap[temp] = heap[temp / 2];
                    temp = temp / 2;
                } else {
                    break;
                }
            }
            heap[temp] = x;
        }

        int pop() {
            if (last == 0) return 0;
            int result = heap[1];
            int temp = 1;
            int x = heap[last];
            while (temp < last / 2.0) {
                if (x < heap[temp * 2]) {
                    heap[temp] = heap[temp * 2];
                    temp = temp * 2;
                } else if (x < heap[temp * 2 + 1]) {
                    heap[temp] = heap[temp * 2 + 1];
                    temp = temp * 2 + 1;
                } else {
                    break;
                }
            }
            heap[temp] = x;
            heap[last] = 0;
            last--;
            return result;
        }

        void print() {
            for (int i = 0; i <= 3; i++) {
                System.out.printf("%d ", heap[i]);
            }
            System.out.println();
        }
    }


}
