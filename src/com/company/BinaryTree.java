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

    public boolean isPresent(String item) {
        if (this.root != null) {
            Queue<BinaryNode> queue = new LinkedList<>();
            queue.add(this.root);

            while (!queue.isEmpty()) {
                BinaryNode current = queue.remove();
                if (current.getItem().equals(item)) {
                    return true;
                }

                if (current.getLeft() != null) {
                    queue.add(current.getLeft());
                }

                if (current.getRight() != null) {
                    queue.add(current.getRight());
                }
            }
        }

        return false;
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

    public BinaryNode getDeepestNode() {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(this.root);
        BinaryNode deepestNode = null;

        while (!queue.isEmpty()) {
            deepestNode = queue.remove();

            if (deepestNode.getLeft() != null) {
                queue.add(deepestNode.getLeft());
            }

            if (deepestNode.getRight() != null) {
                queue.add(deepestNode.getRight());
            }
        }

        return deepestNode;
    }

    public void deleteDeepestNode() {
        if (this.getDeepestNode() != this.root) {
            Queue<BinaryNode> queue = new LinkedList<>();
            queue.add(this.root);
            BinaryNode previous;
            BinaryNode current = null;

            while (!queue.isEmpty()) {
                previous = current;
                current = queue.remove();

                if (current.getLeft() == null) {
                    previous.setRight(null);
                    break;
                }

                if (current.getRight() == null) {
                    current.setLeft(null);
                    break;
                }

                queue.add(current.getLeft());
                queue.add(current.getRight());
            }
        } else {
            this.delete();
        }
    }

    public void deleteNode(String value) {
        if (this.isPresent(value)) {
            Queue<BinaryNode> queue = new LinkedList<>();
            queue.add(this.root);

            while (!queue.isEmpty()) {
                BinaryNode current = queue.remove();

                if (current.getItem().equals(value)) {
                    current.setItem(this.getDeepestNode().getItem());
                    this.deleteDeepestNode();
                    break;
                }

                if (current.getLeft() != null) {
                    queue.add(current.getLeft());
                }

                if (current.getRight() != null) {
                    queue.add(current.getRight());
                }
            }
        }
    }

    public void delete() {
        this.root = null;
    }
}
