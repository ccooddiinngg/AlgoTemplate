package tag.DepthFirstSearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CourseScheduleIITest {
    CourseScheduleII courseScheduleII = new CourseScheduleII();

    @Test
    void test() {
        int numCourses = 5;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}, {1, 4}};
        Assertions.assertArrayEquals(new int[]{4, 0, 2, 1, 3}, courseScheduleII.findOrder(numCourses, prerequisites));
    }

}