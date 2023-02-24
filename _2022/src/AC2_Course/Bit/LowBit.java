package AC2_Course.Bit;

public class LowBit {

    // 110010 x
    // 001101 + 1 -> 001110 -x
    // 110010 & 001110 -> 10
    public int lowBit(int x) {
        return x & (-x);
    }

}
