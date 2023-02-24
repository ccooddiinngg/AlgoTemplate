package ZuoChengyun.BasicPlus.Day1;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ASet {
    public Map<String, Integer> mapString = new HashMap<>();
    public Map<Integer, String> mapInteger = new HashMap<>();
    public int size = 0;

    public void insert(String s) {
        if (!mapString.containsKey(s)) {
            mapString.put(s, size);
            mapInteger.put(size, s);
            size++;
        }
    }

    public void remove(String s) {
        if (mapString.containsKey(s)) {
            mapString.put(mapInteger.get(size - 1), mapString.get(s));
            mapInteger.put(mapString.get(s), mapInteger.get(size - 1));
            mapString.remove(s);
            mapInteger.remove(size - 1);
            size--;
        }
    }

    public String getRandom() {
        if (size == 0) return null;
        int r = new Random().nextInt(size);
        return mapInteger.getOrDefault(r, null);

    }

    @Test
    void test() {
        ASet aSet = new ASet();
        aSet.insert("a");
        aSet.insert("b");
        aSet.insert("c");

        System.out.println(aSet.getRandom());
        aSet.remove("b");
        aSet.remove("a");

        System.out.println(aSet.getRandom());
    }
}
