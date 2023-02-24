package Leetcode.Coding_Interview_6.C17;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class S25Test {
    S25 s25 = new S25();

    @Test
    void test() {
        String[] words = {"this", "real", "hard", "trh", "hea", "iar", "sld"};
        System.out.println(Arrays.toString(s25.maxRectangle(words)));
    }

    @Test
    void test1() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/Leetcode/Coding_Interview_6/C17/S25Data.txt"));

        String[] words = sc.nextLine().split(", ");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].trim().substring(1, words[i].length() - 1);
        }
        System.out.println(Arrays.toString(s25.maxRectangle(words)));
    }

}