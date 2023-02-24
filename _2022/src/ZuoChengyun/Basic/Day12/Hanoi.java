package ZuoChengyun.Basic.Day12;

public class Hanoi {
    public static void hanoi(int n, String a, String b, String c) {
        if (n == 1) {
            System.out.println(a + " => " + c);
            return;
        }
        hanoi(n - 1, a, c, b);
        System.out.println(a + " => " + c);
        hanoi(n - 1, b, a, c);
    }

    public static void main(String[] args) {
        hanoi(8, "a", "b", "c");
    }
}
