package com.company;

public class Main {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert("A");
        tree.insert("B");
        tree.insert("C");
        tree.insert("D");
        tree.insert("E");
        tree.insert("F");
        tree.insert("G");

        tree.traverseLevelOrder();
        System.out.println();
        tree.traversePreOrder(tree.getRoot());
        System.out.println();
        tree.traverseInOrder(tree.getRoot());
        System.out.println();
        tree.traversePostOrder(tree.getRoot());
    }
}
