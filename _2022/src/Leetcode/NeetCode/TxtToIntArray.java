package Leetcode.NeetCode;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TxtToIntArray {
    public static int[] read(String filename) {
        List<String> list = new ArrayList<>();
        try (Scanner s = new Scanner(new FileReader(filename))) {
            while (s.hasNext()) {
                list.add(s.nextLine());
            }
            String[] temp = list.get(0).substring(1, list.get(0).length() - 1).split(",");
            int[] res = new int[temp.length];
            for (int i = 0; i < res.length; i++) {
                res[i] = Integer.parseInt(temp[i]);
            }
            return res;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new int[]{};
    }
}
