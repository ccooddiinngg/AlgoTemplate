package ZuoChengyun.Basic.Day10;

import java.util.Arrays;

public class MeetingRoom {

    static class Meeting {
        int start, end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


    public static int bruteForce(Meeting[] meetings, int timeline, int count) {
        if (meetings.length == 0) {
            return count;
        }
        int max = count;
        int selected = 0;
        for (int i = 0; i < meetings.length; i++) {
            if (meetings[i].start >= timeline) {
                Meeting[] remains = copyButExcept(meetings, i);
                max = Math.max(max, bruteForce(remains, meetings[i].end, count + 1));
            }
        }
        return max;
    }

    private static Meeting[] copyButExcept(Meeting[] meetings, int index) {
        Meeting[] res = new Meeting[meetings.length - 1];
        for (int i = 0, j = 0; i < meetings.length; i++) {
            if (i != index) {
                res[j++] = meetings[i];
            }
        }
        return res;
    }

    /*
     * sort meetings by end time
     * */
    public static int greedy(Meeting[] meetings) {
        Arrays.sort(meetings, (o1, o2) -> o1.end - o2.end);
        int count = 0;
        int timeline = 0;
        for (int i = 0; i < meetings.length; i++) {
            if (meetings[i].start >= timeline) {
                count++;
                timeline = meetings[i].end;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Meeting[] meetings = new Meeting[]{
                new Meeting(1, 2),
                new Meeting(3, 5),
                new Meeting(4, 6),
                new Meeting(2, 4),
                new Meeting(3, 6),
                new Meeting(0, 1),
                new Meeting(5, 6)};
        int count = bruteForce(meetings, 0, 0);
        System.out.println(count);

        int countGreedy = greedy(meetings);
        System.out.println(countGreedy);
    }
}
