package Leetcode.MostInterView;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {
    //use long as map key
    public long getSlope(int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;

        if (dx == 0) {
            return (long) x1 << 32L;
        }
        if (dy == 0) {
            return (long) y1;
        }

        //! gcd always has the same sign with dx, so dx always positive , make | safe
        int gcd = getGCD(dx, dy);
        dx = dx / gcd;
        dy = dy / gcd;
        return ((long) dy << 32L) | (long) dx;
    }

    //! use String as map key
    public String getSlopeString(int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;

        if (dx == 0) {
            return x2 + "," + "0";
        }
        if (dy == 0) {
            return "0" + "," + y1;
        }
        int gcd = getGCD(dx, dy);
        dx = dx / gcd;
        dy = dy / gcd;
        return dy + "," + dx;
    }

    public int getGCD(int m, int n) {
        return n == 0 ? m : getGCD(n, m % n);
    }


    public int maxPoints(int[][] points) {
        if (points.length == 1) {
            return 1;
        }
        int max = 0;
        for (int i = 0; i < points.length - 1; i++) {
            Map<Long, Integer> map = new HashMap<>();
            int count = 0;
            int dup = 1;
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    dup++;
                } else {
                    long slope = getSlope(points[i][0], points[i][1], points[j][0], points[j][1]);
                    map.put(slope, map.getOrDefault(slope, 0) + 1);
                    count = Math.max(count, map.get(slope));
                }
            }
            max = Math.max(max, dup + count);
        }
        return max;
    }
}
