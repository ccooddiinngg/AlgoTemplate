package tag.Tree;

import org.junit.jupiter.api.Test;
import utils.TreeNode;

import java.util.List;

class UniqueBinarySearchTreesIITest {
    UniqueBinarySearchTreesII uniqueBinarySearchTreesII = new UniqueBinarySearchTreesII();

    @Test
    void test() {
        int n = 3;
        List<TreeNode> list = uniqueBinarySearchTreesII.generateTrees(n);
        System.out.println(list);
    }

}