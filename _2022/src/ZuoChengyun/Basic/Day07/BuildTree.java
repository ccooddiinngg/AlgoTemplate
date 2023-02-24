package ZuoChengyun.Basic.Day07;

import ZuoChengyun.Basic.Node;

import java.util.LinkedList;

public class BuildTree {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("4");
        list.add("5");
        list.add("3");
        list.add("6");
        list.add("7");
        list.add(null);
        list.add(null);
        list.add(null);
        list.add(null);
        list.add(null);
        list.add(null);
        list.add(null);
        list.add(null);
        Node root = Tree.deserialize(list);
        Tree.pre(root);

        System.out.println("=====");

        LinkedList<String> listBFS = new LinkedList<>();
        listBFS.add("1");
        listBFS.add("2");
        listBFS.add(null);
        listBFS.add("4");
        listBFS.add(null);
        listBFS.add("6");
        listBFS.add("7");
        Node rootBFS = Tree.deserializeBFS(listBFS);
        Tree.pre(rootBFS);
    }
}
