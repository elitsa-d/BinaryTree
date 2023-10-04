package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private BinaryNode root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryNode getRoot() {
        return this.root;
    }

    public void setRoot(BinaryNode root) {
        this.root = root;
    }

    public void traversePreOrder(BinaryNode root) {
        if (root != null) {
            System.out.print(root.getItem() + " ");
            traversePreOrder(root.getLeft());
            traversePreOrder(root.getRight());
        }
    }

    public void traverseInOrder(BinaryNode root) {
        if (root != null) {
            traverseInOrder(root.getLeft());
            System.out.print(root.getItem() + " ");
            traverseInOrder(root.getRight());
        }
    }

    public void traversePostOrder(BinaryNode root) {
        if (root != null) {
            traversePostOrder(root.getLeft());
            traversePostOrder(root.getRight());
            System.out.print(root.getItem() + " ");
        }
    }

    public void traverseLevelOrder() {
        if (this.root != null) {
            Queue<BinaryNode> queue = new LinkedList<>();
            queue.add(this.root);

            while (!queue.isEmpty()) {
                BinaryNode current = queue.remove();
                System.out.print(current.getItem() + " ");

                if (current.getLeft() != null) {
                    queue.add(current.getLeft());
                }

                if (current.getRight() != null) {
                    queue.add(current.getRight());
                }
            }
        }
    }

    public void insert(String item) {
        BinaryNode newNode = new BinaryNode(item);

        if (this.root == null) {
            this.root = newNode;
        } else {
            Queue<BinaryNode> queue = new LinkedList<>();
            queue.add(this.root);

            while (!queue.isEmpty()) {
                BinaryNode current = queue.remove();
                if (current.getLeft() == null) {
                    current.setLeft(newNode);
                    break;
                } else if (current.getRight() == null) {
                    current.setRight(newNode);
                    break;
                } else {
                    queue.add(current.getLeft());
                    queue.add(current.getRight());
                }
            }
        }
    }
}
