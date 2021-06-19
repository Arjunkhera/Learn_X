package com.arjun.learn.algorithms.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Traversal {

    public static List<Integer> InOrderRecursive(TreeNode root) {
        List<Integer> output = new ArrayList<>();

        if(root != null)
            InOrderRecursiveFunction(root, output);
        return output;
    }

    public static void InOrderRecursiveFunction(TreeNode root, List<Integer> output) {
        if(root.left != null)
            InOrderRecursiveFunction(root.left, output);
        output.add(root.val);
        if(root.right != null)
            InOrderRecursiveFunction(root.right, output);
    }

    public static List<Integer> InOrderStack(TreeNode root) {
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

    public static List<Integer> InOrderMorris(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode prev = null;

        while(root != null) {
            if(root.left == null) {
                res.add(root.val);
                root = root.right;
            } else {
                prev = root.left;
                while(prev.right != root && prev.right != null)
                    prev = prev.right;

                if(prev.right == null) {
                    prev.right = root;
                    root = root.left;
                } else {
                    res.add(root.val);
                    prev.right = null;
                    root = root.right;
                }
            }
        }

        return res;
    }
}
