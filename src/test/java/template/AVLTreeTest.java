package template;

import org.junit.jupiter.api.Test;

class AVLTreeTest {
    AVLTree tree = new AVLTree();

    @Test
    void test() {
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);

        tree.print(tree.root);
    }

}