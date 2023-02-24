package ZuoChengyun.Basic.Day02;

import java.util.HashMap;

public class AHashMap {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(3, 33);
        map.put(2, 22);
        map.put(1, 11);
        map.put(4, 44);
        map.put(5, null);

        for (int key : map.keySet()) {
            System.out.println(map.get(key));
        }
        System.out.println(map.getOrDefault(6, 66));

    }
}
