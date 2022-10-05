package tag.Greedy;

import java.util.*;

public class MinimumCostToHireKWorkers {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        List<P> ps = new ArrayList<>();
        for (int i = 0; i < quality.length; i++) {
            ps.add(new P(wage[i], quality[i]));
        }
        //r从小到大排列, 当前p的最低wage只能满足它左边的wage需求
        ps.sort(Comparator.comparingDouble(P::r));
        //在可选的人中选q最小的k个
        Queue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        double sum = 0;
        double min = Double.MAX_VALUE;
        for (P p : ps) {
            q.offer(p.q);
            sum += p.q;
            if (q.size() > k) {
                sum -= q.poll();
            }
            if (q.size() == k) {
                min = Math.min(min, p.r() * sum);
            }
        }
        return min;
    }

    class P {
        int w;
        int q;

        public P(int w, int q) {
            this.w = w;
            this.q = q;
        }

        double r() {
            return (double) w / (double) q;
        }

    }
}
