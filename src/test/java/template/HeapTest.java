package template;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class HeapTest {

    @Test
    void test() throws FileNotFoundException {
        Heap heap = new Heap(10000);
        Scanner sc = new Scanner(new File("src/test/java/template/heap.txt"));
        int Q = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < Q; i++) {
            String[] str = sc.nextLine().split(" ");
            int op = Integer.parseInt(str[0]);
            int val = 0;
            switch (op) {
                case 1:
                    val = Integer.parseInt(str[1]);
                    heap.offer(val);
                    break;
                case 2:
                    val = Integer.parseInt(str[1]);
                    heap.remove(val);
                    break;
                case 3:
                    System.out.println(heap.peek());
                    break;
                default:
                    break;
            }
        }
    }

}