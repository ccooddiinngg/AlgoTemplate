package Playground;

public class P14 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("345");
        sb.append("6");
        sb.append("78");
        sb.append("90");
        System.out.println(sb);

        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}
