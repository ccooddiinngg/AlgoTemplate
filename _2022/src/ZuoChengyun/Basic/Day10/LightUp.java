package ZuoChengyun.Basic.Day10;

import java.util.HashSet;
import java.util.Set;

public class LightUp {

    public static int bruteForce(String street, int index, Set<Integer> set) {
        if (index == street.length()) {
            for (int i = 0; i < street.length(); i++) {
                if (street.charAt(i) == '.' && !set.contains(i) && !set.contains(i - 1) && !set.contains(i + 1)) {
                    return Integer.MAX_VALUE;
                }
            }
            return set.size();
        }

        int no = bruteForce(street, index + 1, set);
        int yes = Integer.MAX_VALUE;
        if (street.charAt(index) == '.') {
            set.add(index);
            yes = bruteForce(street, index + 1, set);
            set.remove(index);
        }
        return Math.min(no, yes);
    }


    public static int greedy(String street) {
        int count = 0;
        int i = 0;
        while (i < street.length()) {
            if (street.charAt(i) == '.') {
                if (i + 1 < street.length() && street.charAt(i + 1) == '.') {
                    i += 3;
                } else {
                    i += 2;
                }
                count++;
            } else {
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String street = "x....x.............x..x.";
        int min = bruteForce(street, 0, new HashSet<>());
        System.out.println(min);
        int minGreedy = greedy(street);
        System.out.println(minGreedy);
    }
}
