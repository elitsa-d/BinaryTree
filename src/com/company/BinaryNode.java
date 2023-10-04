package com.company;

public class BinaryNode {
    private String item;
    private BinaryNode left;
    private BinaryNode right;

    public BinaryNode(String item) {
        this.item = item;
        this.left = null;
        this.right = null;
    }

    public String getItem() {
        return this.item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public BinaryNode getLeft() {
        return this.left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return this.right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }
}
