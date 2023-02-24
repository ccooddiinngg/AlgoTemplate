package ZuoChengyun.Middle.Day6;

import java.util.Arrays;
import java.util.TreeMap;

public class JobSearch {
    static class Job {
        int salary;
        int level;

        public Job(int salary, int level) {
            this.salary = salary;
            this.level = level;
        }
    }

    public static int[] search(Job[] jobs, int[] members) {
        Arrays.sort(jobs, (o1, o2) -> o1.level == o2.level ? o2.salary - o1.salary : o1.level - o2.level);
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(jobs[0].level, jobs[0].salary);
        Job target = jobs[0];
        for (int i = 1; i < jobs.length; i++) {
            if (jobs[i].level != target.level && jobs[i].salary > target.salary) {
                target = jobs[i];
                treeMap.put(target.level, target.salary);
            }
        }
        int[] ans = new int[members.length];
        for (int i = 0; i < members.length; i++) {
            Integer level = treeMap.floorKey(members[i]);
            ans[i] = level == null ? 0 : treeMap.get(level);
        }
        return ans;
    }
}
