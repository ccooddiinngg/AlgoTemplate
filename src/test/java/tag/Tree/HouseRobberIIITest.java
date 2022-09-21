package tag.Tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import template.BinaryTree;

class HouseRobberIIITest {
    HouseRobberIII houseRobberIII = new HouseRobberIII();

    @Test
    void test() {
        String s = "3,2,3,null,3,null,1";
        BinaryTree binaryTree = new BinaryTree(s, 1);
        int max = houseRobberIII.rob(binaryTree.root);
        Assertions.assertEquals(7, houseRobberIII.rob(binaryTree.root));
    }

}