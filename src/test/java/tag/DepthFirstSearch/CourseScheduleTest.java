package tag.DepthFirstSearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CourseScheduleTest {
    CourseSchedule courseSchedule = new CourseSchedule();

    @Test
    void test() {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
        Assertions.assertFalse(courseSchedule.canFinish(numCourses, prerequisites));
    }

}