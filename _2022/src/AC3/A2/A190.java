package AC3.A2;

import java.util.*;

class A190 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] read = sc.nextLine().split(" ");
        String s1 = read[0];
        String s2 = read[1];
        Map<String, List<String>> map1 = new HashMap<>();
        Map<String, List<String>> map2 = new HashMap<>();
        while (sc.hasNextLine()) {
            read = sc.nextLine().split(" ");
            String from = read[0];
            String to = read[1];
            if (!map1.containsKey(from)) {
                map1.put(from, new ArrayList<>());
            }
            if (!map2.containsKey(to)) {
                map2.put(to, new ArrayList<>());
            }
            map1.get(from).add(to);
            map2.get(to).add(from);
        }
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        q1.offer(s1);
        set1.add(s1);
        q2.offer(s2);
        set2.add(s2);
        int step = 0;
        while (!q1.isEmpty() && !q2.isEmpty() && step <= 10) {
            //todo refactor
            if (q1.size() < q2.size()) {
                int size = q1.size();
                for (int i = 0; i < size; i++) {
                    String curr = q1.poll();
                    if (set2.contains(curr)) {
                        System.out.println(step);
                        return;
                    }
                    for (String key : map1.keySet()) {
                        if (curr.contains(key)) {
                            for (String v : map1.get(key)) {
                                List<String> next = getNext(curr, key, v);
                                for (String nextStr : next) {
                                    if (!set1.contains(nextStr)) {
                                        set1.add(nextStr);
                                        q1.offer(nextStr);
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                int size = q2.size();
                for (int i = 0; i < size; i++) {
                    String curr = q2.poll();
                    if (set1.contains(curr)) {
                        System.out.println(step);
                        return;
                    }
                    for (String key : map2.keySet()) {
                        if (curr.contains(key)) {
                            for (String v : map2.get(key)) {
                                List<String> next = getNext(curr, key, v);
                                for (String nextStr : next) {
                                    if (!set2.contains(nextStr)) {
                                        set2.add(nextStr);
                                        q2.offer(nextStr);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            step++;
        }
        System.out.println("NO ANSWER!");
    }

    public static List<String> getNext(String s, String from, String to) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int idx = s.indexOf(from, i);
            if (idx == -1) {
                break;
            }
            list.add(s.substring(0, idx) + to + s.substring(idx + from.length()));
            i = idx + 1;
        }
        return list;
    }
}




