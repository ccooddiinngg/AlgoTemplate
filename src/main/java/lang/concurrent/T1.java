package lang.concurrent;

public class T1 {
    public static int counter = 0;

    public void add() {
        for (int i = 0; i < 10000; i++) {
            synchronized (this) {
                counter++;
            }
        }
    }

    public void sub() {
        for (int i = 0; i < 10000; i++) {
            synchronized (this) {
                counter--;
            }
        }
    }
}
