package ZuoChengyun.Basic.Day10;

import java.util.*;

public class FindDuplicate {

    public static class User {
        public String a;
        public String b;
        public String c;

        public User(String a, String b, String c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static UnionSet<User> unionSet(List<User> users) {
        UnionSet<User> set = new UnionSet<>(users);
        Map<String, User> mapA = new HashMap<>();
        Map<String, User> mapB = new HashMap<>();
        Map<String, User> mapC = new HashMap<>();

        for (User user : set.nodes.keySet()) {
            if (!mapA.containsKey(user.a)) {
                mapA.put(user.a, user);
            } else {
                set.union(user, mapA.get(user.a));
            }
            if (!mapB.containsKey(user.b)) {
                mapB.put(user.b, user);
            } else {
                set.union(user, mapB.get(user.b));
            }
            if (!mapC.containsKey(user.c)) {
                mapC.put(user.c, user);
            } else {
                set.union(user, mapC.get(user.c));
            }
        }

        return set;
    }

    public static void main(String[] args) {
        User a = new User("123", "abc", "a1");
        User b = new User("234", "abc", "b1");
        User c = new User("123", "abu", "c1");
        User d = new User("143", "xyz", "b1");

        List<User> users = new ArrayList<>(Arrays.asList(a, b, c, d));
        UnionSet<User> set = unionSet(users);
        System.out.println(set.isSameSet(a, d));

        System.out.println(set.sizeMap.size());
    }
}
