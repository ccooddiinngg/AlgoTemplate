package Playground.Tree;

@FunctionalInterface
public interface Deserializer {
    TreeNode deserialize(String[] strs);
}
