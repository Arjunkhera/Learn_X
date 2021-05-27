package com.arjun.learn.algorithms.trees;

public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
        left = right = null;
    }

    public TreeNode(int val) {
        data = val;
        left = right = null;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        data = val;
        this.left = left;
        this.right = right;
    }
}
