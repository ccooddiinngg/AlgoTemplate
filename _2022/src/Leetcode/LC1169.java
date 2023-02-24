package Leetcode;

import java.util.*;

public class LC1169 {
    public List<String> invalidTransactions(String[] transactions) {
        Map<String, List<Info>> map = new HashMap<>();
        for (int i = 0; i < transactions.length; i++) {
            String transaction = transactions[i];
            String[] trans = transaction.split(",");
            String name = trans[0];
            int time = Integer.parseInt(trans[1]);
            int amount = Integer.parseInt(trans[2]);
            String city = trans[3];
            if (!map.containsKey(name)) {
                map.put(name, new ArrayList<>());
            }
            map.get(name).add(new Info(time, amount, city, i));
        }
        Set<Integer> invalid = new HashSet<>();
        List<String> invalidTransactions = new ArrayList<>();

        for (String key : map.keySet()) {
            List<Info> list = map.get(key);
            list.sort((a, b) -> a.time - b.time);
            for (int i = 0; i < list.size(); i++) {
                int j = i - 1;
                while (j >= 0 && list.get(i).time - list.get(j).time <= 60) {
                    if (!list.get(i).city.equals(list.get(j).city)) {
                        int idx1 = list.get(i).idx;
                        int idx2 = list.get(j).idx;
                        invalid.add(idx1);
                        invalid.add(idx2);
                    }
                    j--;
                }

                if (list.get(i).amount > 1000) {
                    invalid.add(list.get(i).idx);
                }
            }
        }
        // System.out.println(invalid);
        for (int idx : invalid) {
            invalidTransactions.add(transactions[idx]);
        }
        return invalidTransactions;
    }

    class Info {
        String city;
        int time;
        int amount;
        int idx;

        public Info(int time, int amount, String city, int idx) {
            this.time = time;
            this.amount = amount;
            this.city = city;
            this.idx = idx;
        }
    }
}
