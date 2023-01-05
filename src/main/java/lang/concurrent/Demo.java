package lang.concurrent;

public class Demo {
    public static void main(String[] args) throws InterruptedException {

        T1 t1 = new T1();

        Thread add = new Thread(t1::add);
        Thread sub = new Thread(t1::sub);

        add.start();
        sub.start();

        add.join();
        sub.join();

        System.out.println(T1.counter);
        System.out.println("Done");
    }
}


