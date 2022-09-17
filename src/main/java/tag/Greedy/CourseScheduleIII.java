package tag.Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class CourseScheduleIII {
    public int scheduleCourse(int[][] courses) {
        //优先选结束时间早的
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        Queue<int[]> q = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int sum = 0;
        for (int[] course : courses) {
            q.offer(course);
            sum += course[0];
            //如果不能完成，去除时间最长的一个
            if (sum > course[1]) {
                sum -= q.poll()[0];
            }
        }
        return q.size();
    }
}
