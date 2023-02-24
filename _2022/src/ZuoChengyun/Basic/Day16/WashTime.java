package ZuoChengyun.Basic.Day16;

import org.junit.jupiter.api.Test;

public class WashTime {

    public static int wash(int[] cups, int washTime, int dryTime, int index, int timeline) {
        if (index == cups.length - 1) {
            return Math.min(Math.max(timeline, cups[index]) + washTime, cups[index] + dryTime);
        }
//        if (index == cups.length) {
//            return timeline;
//        }

        int washT = Math.max(timeline, cups[index]) + washTime;
        int washNextT = wash(cups, washTime, dryTime, index + 1, washT);
        int o1 = Math.max(washT, washNextT);

        int dryT = cups[index] + dryTime;
        int dryNextT = wash(cups, washTime, dryTime, index + 1, timeline);
        int o2 = Math.max(dryT, dryNextT);

        return Math.min(o1, o2);
    }

    @Test
    void washTest() {
        int[] cups = {1, 1, 2, 2, 2, 3, 4, 5};
        int washTime = 5;
        int dryTime = 8;

        int time = wash(cups, washTime, dryTime, 0, 0);
        System.out.println(time);
    }
}
