package AC2_Course.Bit;

public class Count1 {

    public static void main(String[] args) {
        int x = 10;
        int count = 0;
        while (x != 0) {
            x -= lowBit(x);
            count++;
        }
        System.out.print(count + " ");
    }

    static int lowBit(int x) {
        return x & -x;
    }

}
