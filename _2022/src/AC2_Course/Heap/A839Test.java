package AC2_Course.Heap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class A839Test {
    public static void main(String[] args) throws FileNotFoundException {
        A839 heap = new A839();
        Scanner sc = new Scanner(new File("src/ACWING/Heap/A839Data.txt"));
        int N = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < N; i++) {
            String[] read = sc.nextLine().split(" ");
            String op = read[0];
            int k = 0;
            int v = 0;
            switch (op) {
                case "I" -> {
                    v = Integer.parseInt(read[1]);
                    heap.add(v);
                }
                case "PM" -> {
                    v = heap.peek();
                    System.out.println(v);
                }
                case "DM" -> heap.pop();
                case "D" -> {
                    k = Integer.parseInt(read[1]);
                    heap.delete(k);
                }
                case "C" -> {
                    k = Integer.parseInt(read[1]);
                    v = Integer.parseInt(read[2]);
                    heap.update(k, v);
                }
                default -> {
                }
            }
        }
    }
}