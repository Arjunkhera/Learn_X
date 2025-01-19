package com.arjun.learn.algorithms.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest {

  BinarySearchTree binarySearchTree = new BinarySearchTree();
  int[] values = new int[]{4,2,7,1,3,5};

  {
    binarySearchTree.insert(4, false);
    binarySearchTree.insert(2, false);
    binarySearchTree.insert(7, false);
    binarySearchTree.insert(1, false);
    binarySearchTree.insert(3, false);
    binarySearchTree.insert(5, false);
  }

  @Test
  public void checkInsertion() {
    BinarySearchTree iterative = new BinarySearchTree();
    iterative.insert(4, false);
    iterative.insert(2, false);
    iterative.insert(7, false);
    iterative.insert(1, false);
    iterative.insert(3, false);
    iterative.insert(5, false);

    BinarySearchTree recursive = new BinarySearchTree();
    recursive.insert(4, true);
    recursive.insert(2, true);
    recursive.insert(7, true);
    recursive.insert(1, true);
    recursive.insert(3, true);
    recursive.insert(5, true);

    assertTrue(BinarySearchTree.sameTree(iterative.root, recursive.root));
  }

  @Test
  public void searchTest() {
    TreeNode res = binarySearchTree.search(7);
    assertNotNull(res);
    assertEquals(res.val, 7);
    assertNull(binarySearchTree.search(8));
  }

  @Test
  public void checkDeletionInnerNode() {
    BinarySearchTree binarySearchTree = new BinarySearchTree();
    binarySearchTree.construct(values);
    binarySearchTree.delete(2, true);
    List<Integer> inorder = Traversal.InOrderStack(binarySearchTree.root);
    assertEquals(inorder, List.of(1,3,4,5,7));

    binarySearchTree.root = null;
    binarySearchTree.construct(values);
    binarySearchTree.delete(2, false);
    inorder = Traversal.InOrderStack(binarySearchTree.root);
    assertEquals(inorder, List.of(1,3,4,5,7));
  }

  @Test
  public void checkDeletionInnerNoLeftTree() {
    BinarySearchTree binarySearchTree = new BinarySearchTree();
    binarySearchTree.construct(new int[]{7,6,4,2,1,3,8});
    binarySearchTree.delete(6, true);
    List<Integer> inorder = Traversal.InOrderStack(binarySearchTree.root);
    assertEquals(inorder, List.of(1,2,3,4,7,8));

    binarySearchTree.root = null;
    binarySearchTree.construct(new int[]{7,6,4,2,1,3,8});
    binarySearchTree.delete(6, false);
    inorder = Traversal.InOrderStack(binarySearchTree.root);
    assertEquals(inorder, List.of(1,2,3,4,7,8));
  }

  @Test
  public void checkDeletionLeafNode() {
    BinarySearchTree binarySearchTree = new BinarySearchTree();
    binarySearchTree.construct(values);
    binarySearchTree.delete(3, true);
    List<Integer> inorder = Traversal.InOrderStack(binarySearchTree.root);
    assertEquals(inorder, List.of(1,2,4,5,7));

    binarySearchTree.root = null;
    binarySearchTree.construct(values);
    binarySearchTree.delete(3, false);
    inorder = Traversal.InOrderStack(binarySearchTree.root);
    assertEquals(inorder, List.of(1,2,4,5,7));
  }

  @Test
  public void checkDeletionRootNode() {
    BinarySearchTree binarySearchTree = new BinarySearchTree();
    binarySearchTree.construct(values);
    binarySearchTree.delete(4, true);
    List<Integer> inorder = Traversal.InOrderStack(binarySearchTree.root);
    assertEquals(inorder, List.of(1,2,3,5,7));

    binarySearchTree.root = null;
    binarySearchTree.construct(values);
    binarySearchTree.delete(4, false);
    inorder = Traversal.InOrderStack(binarySearchTree.root);
    assertEquals(inorder, List.of(1,2,3,5,7));
  }

  @Test
  public void checkDeletionSingleNodeTree() {
    BinarySearchTree binarySearchTree = new BinarySearchTree();
    binarySearchTree.construct(new int[]{3});
    binarySearchTree.delete(3, true);
    List<Integer> inorder = Traversal.InOrderStack(binarySearchTree.root);
    assertEquals(inorder.size(), 0);

    binarySearchTree.root = null;
    binarySearchTree.construct(new int[]{3});
    binarySearchTree.delete(3, false);
    inorder = Traversal.InOrderStack(binarySearchTree.root);
    assertEquals(inorder.size(), 0);
  }
}
