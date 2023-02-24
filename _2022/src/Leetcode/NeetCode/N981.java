package Leetcode.NeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//@@ Map.Entry<Integer, String> entry could be null
public class N981 {
    Map<String, TreeMap<Integer, String>> map;

    public N981() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new TreeMap<Integer, String>());
        }
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        Map.Entry<Integer, String> entry = map.get(key).floorEntry(timestamp);

        //@@ entry could be null
        if (entry == null) {
            return "";
        }
        return entry.getValue();
    }

    public static void main(String[] args) {
        N981 timeMap = new N981();
        timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
        timeMap.get("foo", 1);         // return "bar"
        timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
        timeMap.get("foo", 4);         // return "bar2"
        timeMap.get("foo", 5);
    }
}
