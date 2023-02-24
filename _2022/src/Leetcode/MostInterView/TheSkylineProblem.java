package Leetcode.MostInterView;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class TheSkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 1);

        List<Point> points = buildPoints(buildings);
        for (Point p : points) {
            int max = map.lastKey();
            if (p.in) {
                map.put(p.h, map.getOrDefault(p.h, 0) + 1);
                if (p.h > max) {
                    List<Integer> kp = new ArrayList<>();
                    kp.add(p.x);
                    kp.add(p.h);
                    res.add(kp);
                }
            } else {
                int count = map.get(p.h) - 1;
                if (count == 0) {
                    map.remove(p.h);
                } else {
                    map.put(p.h, map.get(p.h) - 1);
                }
                int currentMax = map.lastKey();
                if (currentMax < max) {
                    List<Integer> kp = new ArrayList<>();
                    kp.add(p.x);
                    kp.add(currentMax);
                    res.add(kp);
                }
            }
        }
        return res;
    }

    public List<Point> buildPoints(int[][] buildings) {
        List<Point> list = new ArrayList<>();
        for (int[] building : buildings) {
            list.add(new Point(building[0], building[2], true));
            list.add(new Point(building[1], building[2], false));
        }
        list.sort((a, b) -> {
            if (a.x == b.x) {
                if (a.in && b.in) {
                    return b.h - a.h;
                }
                if (!a.in && b.in) {
                    return 1;
                }
                if (a.in && !b.in) {
                    return -1;
                }
                return a.h - b.h;
            }
            return a.x - b.x;
        });
        return list;
    }

    class Point {
        int x;
        int h;
        boolean in;

        public Point(int x, int h, boolean in) {
            this.x = x;
            this.h = h;
            this.in = in;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", h=" + h +
                    ", in=" + in +
                    '}' + "\n";
        }

    }

    public static void main(String[] args) {
        TheSkylineProblem theSkylineProblem = new TheSkylineProblem();
        int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        int[][] buildings1 = {{0, 2, 3}, {2, 5, 3}};
        System.out.println(theSkylineProblem.getSkyline(buildings1));
    }
}
