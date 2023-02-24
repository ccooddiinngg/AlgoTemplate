package ZuoChengyun.Basic.Day08;

import java.util.ArrayList;
import java.util.List;

public class FoldingPaper {
    //
    public static void print(int level, int i, int bool) {
        if (i == level) return;
        print(level, i + 1, 0);
        System.out.print("-" + bool + "-");
        print(level, i + 1, 1);
    }

    public static void print1(int level, int i, int bool, List<Integer> list) {
        if (i == level) return;
        print1(level, i + 1, 0, list);
        list.add(bool);
        print1(level, i + 1, 1, list);
    }

    public static void main(String[] args) {
        FoldingPaper.print(3, 0, 0);
        System.out.println();


        List<Integer> list = new ArrayList<>();
        FoldingPaper.print1(3, 0, 0, list);
        System.out.println(list);
    }
}

