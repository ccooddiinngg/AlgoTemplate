package Playground;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(1);
        List<Integer> l = list.stream().distinct().toList();
        System.out.println(l);

        
    }

}
