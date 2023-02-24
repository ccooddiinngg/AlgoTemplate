package ZuoChengyun.Basic.Day02;

import java.util.EmptyStackException;

public class QueueArray {
    int[] array;
    int head = 0;
    int tail = 0;
    int size = 0;

    public QueueArray(int capacity) {
        array = new int[capacity];
    }

    void push(int val) {
        if (isFull()) {
            return;
        }
        array[tail] = val;
        tail = nextIndex(tail);
        size++;
    }

    int pull() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int val = array[head];
        head = nextIndex(head);
        size--;
        return val;
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean isFull() {
        return size >= array.length;
    }

    int nextIndex(int index) {
        return (index + 1) >= array.length ? 0 : index + 1;
    }

    void print() {
        if (isEmpty()) {
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(array[(i + head) % array.length]);
        }
    }

    public static void main(String[] args) {
        QueueArray queueArray = new QueueArray(5);

        queueArray.print();
        System.out.println();
    }
}
