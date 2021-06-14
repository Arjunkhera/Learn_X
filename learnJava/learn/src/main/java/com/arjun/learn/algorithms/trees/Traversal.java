package com.arjun.learn.algorithms.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Traversal {

    public List<Integer> InOrderRecursive(TreeNode root) {
        List<Integer> output = new ArrayList<>();

        if(root != null)
            solve(root, output);
        return output;
    }

    public void solve(TreeNode root, List<Integer> output) {
        if(root.left != null)
            solve(root.left, output);
        output.add(root.val);
        if(root.right != null)
            solve(root.right, output);
    }

    public List<Integer> InOrderStack(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            output.add(root.val);
            root = root.right;
        }

        return output;
    }
}
