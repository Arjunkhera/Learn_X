package com.arjun.learn.algorithms.trees;


public class BinarySearchTree {
    TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(TreeNode treeNode) {
        root = treeNode;
    }

    public void insert(int value) {
        TreeNode node = root;

        while(node != null) {
            if(node.val > value) {
                if(node.left == null) {
                    node.left = new TreeNode(value);
                    return;
                }
                node = node.left;
            } else {
                if(node.right == null) {
                    node.right = new TreeNode(value);
                    return;
                }
                node = node.right;
            }
        }

        this.root = new TreeNode(value);
    }
}
