package com.arjun.learn.algorithms.trees;

public class BinarySearchTree {

    TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(TreeNode treeNode) {
        root = treeNode;
    }

    public void construct(int[] values) {
        for (int val : values) {
            insert(val, false);
        }
    }

    public void insert(int value, boolean recursive) {
        if (recursive) {
            insertRecursive(value);
        } else {
            insertIterative(value);
        }
    }

    public void insertIterative(int value) {
        TreeNode node = root;

        while (node != null) {
            if (node.val > value) {
                if (node.left == null) {
                    node.left = new TreeNode(value);
                    return;
                }
                node = node.left;
            } else {
                if (node.right == null) {
                    node.right = new TreeNode(value);
                    return;
                }
                node = node.right;
            }
        }

        this.root = new TreeNode(value);
    }

    public void insertRecursive(int value) {
        this.root = add(this.root, value);
    }

    public TreeNode add(TreeNode node, int value) {
        if (node == null) {
            return new TreeNode(value);
        }

        if (node.val > value) {
            node.left = add(node.left, value);
        } else {
            node.right = add(node.right, value);
        }

        return node;
    }

    public TreeNode search(int value) {
        TreeNode cur = this.root;
        while (cur != null) {
            if (cur.val == value) {
                return cur;
            }
            if (cur.val > value) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        return null;
    }

    public void delete(int value, boolean recursive) {
        if (recursive) {
            deleteRecursive(value);
        } else {
            deleteIterative(value);
        }
    }

    public void deleteRecursive(int value) {
        this.root = deleteRecursiveFunction(this.root, value);
    }

    public TreeNode deleteRecursiveFunction(TreeNode current, int value) {
        if (current == null) {
            return null;
        }

        if (current.val > value) {
            current.left = deleteRecursiveFunction(current.left, value);
        } else if (current.val < value) {
            current.right = deleteRecursiveFunction(current.right, value);
        } else {
            if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            }

            int minValue = findMinValueInTree(current.right);
            current.val = minValue;
            current.right = deleteRecursiveFunction(current.right, minValue);
        }

        return current;
    }

    public int findMinValueInTree(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
    }

    public void deleteIterative(int value) {
        TreeNode parent = null, cur = this.root;
        while (cur != null && cur.val != value) {
            parent = cur;
            if (cur.val > value) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        if (parent == null) {
            this.root = deleteNode(cur);
        } else if (parent.left == cur) {
            parent.left = deleteNode(cur);
        } else {
            parent.right = deleteNode(cur);
        }
    }

    public TreeNode deleteNode(TreeNode node) {
        if (node == null) {
            return null;
        }

        if (node.left == null) {
            return node.right;
        } else if (node.right == null) {
            return node.left;
        }

        TreeNode parent = null, current = node.right;
        for (; current.left != null; parent = current, current = current.left) {
        }
        current.left = node.left;
        if (parent != null) {
            parent.left = current.right;
            current.right = node.right;
        }

        return current;
    }

    public static boolean sameTree(TreeNode first, TreeNode second) {
        if (first == null && second == null) {
            return true;
        }
        if (first == null || second == null) {
            return false;
        }

        return first.val == second.val && sameTree(first.left, second.left) && sameTree(first.right,
                second.right);
    }
}
