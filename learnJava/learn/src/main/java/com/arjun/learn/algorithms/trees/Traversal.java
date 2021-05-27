package com.arjun.learn.algorithms.trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class Traversal {

    public void InOrderRecursive(TreeNode root) {
        if(root == null) return;
        solve(root);
    }

    public void solve(TreeNode root) {
        if(root.left != null)
            solve(root.left);
        System.out.println(root.data);
        if(root.right != null)
            solve(root.right);
    }

    public void InOrderStack(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(root != null) {
            stack.offerLast(root);
            root = root.left;
        }

        while(!stack.isEmpty()) {
            TreeNode cur = stack.pollLast();
            System.out.println(cur.data);

            cur = cur.right;
            while(cur != null) {
                stack.offerLast(cur);
                cur = cur.left;
            }
        }
    }

    public void InOrderMorris(TreeNode root) {
        System.out.println("ToDo");
    }
}
