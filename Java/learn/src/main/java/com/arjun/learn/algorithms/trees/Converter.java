package com.arjun.learn.algorithms.trees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Converter {
  public static String serialize(TreeNode root) {
    StringBuilder str = new StringBuilder();
    encode(root, str);
    return str.toString();
  }

  public static void encode(TreeNode root, StringBuilder str) {
    if(root == null) {
      str.append("null").append(",");
      return;
    }

    str.append(root.val).append(",");
    encode(root.left, str);
    encode(root.right, str);
  }

  public static TreeNode deserialize(String encoded) {
    return decode(new ArrayDeque<>(List.of(encoded.split(","))));
  }

  public static TreeNode decode(Deque<String> q) {
    if(q.isEmpty()) return null;

    String cur = q.pollFirst();
    if(cur.equals("null")) return null;

    TreeNode node = new TreeNode(Integer.parseInt(cur));
    node.left = decode(q);
    node.right = decode(q);
    return node;
  }
}
