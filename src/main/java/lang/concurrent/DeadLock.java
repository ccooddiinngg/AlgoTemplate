package lang.concurrent;

public class DeadLock {

    public static void main(String[] args) throws InterruptedException {
        T t = new T();

        Thread t1 = new Thread(t::add);
        Thread t2 = new Thread(t::sub);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(t.getCounter());
    }

}

class T {
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    public static int counter = 0;

    public void add() {
        for (int i = 0; i < 10000; i++) {
            synchronized (lock1) {
                synchronized (lock2) {
                    counter++;
                    System.out.println(counter);
                }
            }
        }
    }

    public void sub() {
        for (int i = 0; i < 10000; i++) {
            synchronized (lock2) {
                synchronized (lock1) {
                    counter--;
                    System.out.println(counter);
                }
            }
        }
    }

    public int getCounter() {
        return counter;
    }
}
