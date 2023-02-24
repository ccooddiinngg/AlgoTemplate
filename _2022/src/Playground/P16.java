package Playground;

public class P16 {
    public static void main(String[] args) {
        String s = "John(15)";
        String s1 = s.substring(0, s.length() - 1);
        String[] s2 = s1.split("\\(");
    }
}
