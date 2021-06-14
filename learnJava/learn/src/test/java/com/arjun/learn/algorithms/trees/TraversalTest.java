package com.arjun.learn.algorithms.trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TraversalTest {

    BinarySearchTree tree = new BinarySearchTree();
    Traversal traversal = new Traversal();

    @BeforeEach
    public void constructTree() {
        tree.insert(4);
        tree.insert(2);
        tree.insert(7);
        tree.insert(1);
        tree.insert(3);
        tree.insert(5);
    }

    @Test
    public void inOrderRecursiveTest() {
        List<Integer> output = traversal.InOrderRecursive(tree.root);
        assertEquals(output, List.of(1,2,3,4,5,7));
    }

    @Test
    public void inOrderIterativeTest() {
        List<Integer> output = traversal.InOrderStack(tree.root);
        assertEquals(output, List.of(1,2,3,4,5,7));
    }
}
