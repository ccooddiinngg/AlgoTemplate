package ZuoChengyun.Basic.Day03;

public class TotalSum {

    static int divide(int[] array, int left, int right) {
        if (left == right - 1) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        return divide(array, left, mid) +
                divide(array, mid, right) +
                merge(array, left, mid, right);
    }

    static int merge(int[] array, int left, int mid, int right) {
        int sum = 0;
        int i = left;
        int j = mid;
        int[] temp = new int[right - left];
        int k = 0;
        while (i < mid && j < right) {
            if (array[i] < array[j]) {
                sum += array[i] * (right - j);
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        while (i < mid) {
            temp[k++] = array[i++];
        }
        while (j < right) {
            temp[k++] = array[j++];
        }
        int m = 0;
        int n = left;
        while (m < temp.length) {
            array[n++] = temp[m++];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 4, 2, 5};
        int sum = divide(array, 0, array.length);
        System.out.println(sum);
    }
}
