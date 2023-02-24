package ZuoChengyun.Basic.Day02;

public class MaxNumber {
    public static void main(String[] args) {
        int[] array = {5, 3, 2, 1, 4};
        System.out.println(max(array, 0, array.length));
    }

    static int max(int[] array, int left, int right) {
        if (left == right - 1) {
            return array[left];
        }
        int mid = left + (right - left) / 2;
        return Math.max(max(array, left, mid), max(array, mid, right));
    }
}
