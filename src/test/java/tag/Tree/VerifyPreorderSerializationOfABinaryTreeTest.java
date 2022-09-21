package tag.Tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class VerifyPreorderSerializationOfABinaryTreeTest {
    VerifyPreorderSerializationOfABinaryTree verifyPreorderSerializationOfABinaryTree = new VerifyPreorderSerializationOfABinaryTree();

    @Test
    void test() {
        String s = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        Assertions.assertTrue(verifyPreorderSerializationOfABinaryTree.isValidSerialization(s));
    }

}