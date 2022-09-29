package tag.BinaryIndexTree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QueueReconstructionByHeightTest {

    QueueReconstructionByHeight queueReconstructionByHeight = new QueueReconstructionByHeight();

    @Test
    void test() {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] res = queueReconstructionByHeight.reconstructQueue(people);
        Assertions.assertArrayEquals(new int[][]{{5, 0}, {7, 0}, {5, 2}, {6, 1}, {4, 4}, {7, 1}}, res);
    }
}