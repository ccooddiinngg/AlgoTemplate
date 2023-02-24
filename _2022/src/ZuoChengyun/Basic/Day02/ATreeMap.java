package ZuoChengyun.Basic.Day02;

import java.util.TreeMap;

public class ATreeMap {

    public static void main(String[] args) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        treeMap.put(3, 333);
        treeMap.put(1, 111);
        treeMap.put(2, 222);
        treeMap.put(5, 555);

        for (int key : treeMap.keySet()) {
            System.out.println(treeMap.get(key));
        }

        System.out.println(treeMap.firstKey());
    }
}
