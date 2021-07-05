package com.arjun.learn.algorithms.trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TraversalTest {

    BinarySearchTree tree = new BinarySearchTree();

    @BeforeEach
    public void constructTree() {
        int[] values = new int[]{4,2,7,1,3,5};
        for(int val : values)
            tree.insert(val, false);
    }

    @Test
    public void inOrderRecursiveTest() {
        List<Integer> output = Traversal.InOrderRecursive(tree.root);
        assertEquals(output, List.of(1,2,3,4,5,7));
    }

    @Test
    public void inOrderIterativeTest() {
        List<Integer> output = Traversal.InOrderStack(tree.root);
        assertEquals(output, List.of(1,2,3,4,5,7));
    }

    @Test
    public void inOrderMorrisTest() {
        List<Integer> output = Traversal.InOrderMorris(tree.root);
        assertEquals(output, List.of(1,2,3,4,5,7));
    }

    @Test
    public void preOrderRecursiveTest() {
        List<Integer> output = Traversal.PreOrderRecursive(tree.root);
        assertEquals(output, List.of(4,2,1,3,7,5));
    }

    @Test
    public void preOrderIterativeTest() {
        List<Integer> output = Traversal.PreOrderStack(tree.root);
        assertEquals(output, List.of(4,2,1,3,7,5));
    }

    @Test
    public void postOrderRecursiveTest() {
        List<Integer> output = Traversal.PostOrderRecursive(tree.root);
        assertEquals(output, List.of(1,3,2,5,7,4));
    }

    @Test
    public void postOrderIterativeTest() {
        List<Integer> output = Traversal.PostOrderStack(tree.root);
        assertEquals(output, List.of(1,3,2,5,7,4));
    }
}
