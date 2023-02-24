package ZuoChengyun.Basic.Utils;

import ZuoChengyun.Basic.Day02.ZLinkedList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;

public final class Utils {

    public static int[] createRandomIntArray(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * length);
        }
        return arr;
    }

    public static void print(Object[] toPrint) {
        System.out.println(Arrays.toString(toPrint));

    }

    public static <T> void print(List<T> toPrint) {
        for (T element : toPrint) {
            System.out.println(element);
        }
    }

    public static <T> void print(Set<T> toPrint) {
        for (T element : toPrint) {
            System.out.println(element);
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static <T extends Comparable<T>> boolean greater(T lhs, T rhs) {
        return lhs.compareTo(rhs) > 0;
    }

    public static <T extends Comparable<T>> boolean less(T lhs, T rhs) {
        return lhs.compareTo(rhs) < 0;
    }

    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (greater(array[i], array[i + 1])) {
                return false;
            }
        }
        return true;
    }

    public static ZLinkedList getLinkedList(int number) {
        ZLinkedList list = new ZLinkedList();
        for (int i = 0; i < number; i++) {
            list.insert(new Random().nextInt(number));
        }
        list.print();
        return list;
    }

    public static void print2DArray(int[][] array) {
        for (int j = 0; j < array[0].length; j++) {
            if (j == 0) {
                System.out.print("✠");
            }
            System.out.print("\t" + j);
        }
        System.out.println();
        System.out.print("\t");
        for (int j = 0; j < array[0].length; j++) {
            System.out.print("----");
        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(i + "|" + "\t");
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.print("\t");
        for (int j = 0; j < array[0].length; j++) {

            System.out.print("----");
        }
        System.out.println();
    }

    public static void print2DArray(boolean[][] array) {
        for (int j = 0; j < array[0].length; j++) {
            if (j == 0) {
                System.out.print("✠");
            }
            System.out.print("\t" + j);
        }
        System.out.println();
        System.out.print("\t");
        for (int j = 0; j < array[0].length; j++) {
            System.out.print("----");
        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(i + "|" + "\t");
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.print("\t");
        for (int j = 0; j < array[0].length; j++) {

            System.out.print("----");
        }
        System.out.println();
    }

    public static String generateRandomAlphabeticString(int length) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

    }

    public static String readFile(String path) {
        Path p = Path.of(path);
        try {
            return Files.readString(p);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void writeFile(String text, String path) {
        Path p = Path.of(path);
        try {
            Files.writeString(p, text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
