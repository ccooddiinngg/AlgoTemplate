package tag.Tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import template.BinaryTree;

class FindBottomLeftTreeValueTest {
    FindBottomLeftTreeValue findBottomLeftTreeValue = new FindBottomLeftTreeValue();

    @Test
    void test() {
        String s = "1,2,3,4,null,5,6,null,null,7";
        BinaryTree binaryTree = new BinaryTree(s, 1);
        int bottomLeftValue = findBottomLeftTreeValue.findBottomLeftValue(binaryTree.root);
        Assertions.assertEquals(7, bottomLeftValue);
    }

}