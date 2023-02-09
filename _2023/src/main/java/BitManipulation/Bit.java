package BitManipulation;

public class Bit {
    public int lowBit(int x) {
        return x & -x;
    }

    public int removeRight1(int x) {
        return x & (x - 1);
    }

//    X ^ X == 0
}
