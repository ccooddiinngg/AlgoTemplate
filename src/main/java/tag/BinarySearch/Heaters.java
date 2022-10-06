package tag.BinarySearch;

import java.util.Arrays;

//为每个房子找一个最近的heater
public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int max = Integer.MIN_VALUE;
        for (int house : houses) {
            int r = findR(heaters, house);
            int l = findL(heaters, house);
            int min = Integer.MAX_VALUE;
            if (r < heaters.length) {
                min = heaters[r] - house;
            }
            if (l >= 0) {
                min = Math.min(min, house - heaters[l]);
            }
            max = Math.max(max, min);
        }
        return max;
    }

    int findR(int[] heaters, int house) {
        int i = 0;
        int j = heaters.length;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (heaters[mid] >= house) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }

    int findL(int[] heaters, int house) {
        int i = -1;
        int j = heaters.length - 1;
        while (i < j) {
            int mid = i + (j - i + 1) / 2;
            if (heaters[mid] <= house) {
                i = mid;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }
}
