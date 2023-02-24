package Leetcode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CreateMyACList {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("src/Leetcode/MyAC.txt"));
        List<String> list = new ArrayList<>();
        while (sc.hasNextLine()) {
            String[] strs = sc.nextLine().split("/");
            String titleSlug = strs[strs.length - 1];
            list.add(titleSlug);
        }
        sc.close();
        System.out.println(list.size());
    }
}