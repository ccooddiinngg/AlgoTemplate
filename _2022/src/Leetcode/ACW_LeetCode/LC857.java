package Leetcode.ACW_LeetCode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC857 {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = wage.length;
        List<P> list = new ArrayList<>();
        for (int i = 0; i < wage.length; i++) {
            list.add(new P(quality[i], wage[i]));
        }
        list.sort(P::compareTo);
        Queue<P> q = new PriorityQueue<>((a, b) -> b.q - a.q);
        int qSum = 0;
        double min = Double.MAX_VALUE;
        for (P p : list) {
            q.offer(p);
            qSum += p.q;

            if (q.size() > k) {
                qSum -= q.poll().q;
            }
            if (q.size() == k) {
                min = Math.min(min, p.r() * qSum);
            }
        }
        return min;
    }

    class P {
        int q;
        int w;

        public P(int q, int w) {
            this.q = q;
            this.w = w;
        }

        double r() {
            return (double) w / (double) q;
        }

        public int compareTo(P p) {
            return Double.compare(r(), p.r());
        }

    }

    @Test
    void test() {
        int[] wage = {70, 50, 30};
        int[] quality = {10, 20, 5};
        int k = 2;
        System.out.println(mincostToHireWorkers(quality, wage, k));
    }
}
