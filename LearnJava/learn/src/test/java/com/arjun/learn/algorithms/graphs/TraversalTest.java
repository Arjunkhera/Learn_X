package com.arjun.learn.algorithms.graphs;

import org.junit.Test;

import java.util.Map;

public class TraversalTest {

    @Test
    public void testDfs() {
        Traversal traversal = new Traversal();

        traversal.addUndirectedEdge(0,1);
        traversal.addUndirectedEdge(0,4);
        traversal.addUndirectedEdge(1,2);
        traversal.addUndirectedEdge(1,3);
        traversal.addUndirectedEdge(1,4);
        traversal.addUndirectedEdge(2,3);
        traversal.addUndirectedEdge(3,4);

        Map<Integer, Integer> parents = traversal.dfs();
    }

    @Test
    public void testBfs() {
        Traversal traversal = new Traversal();

        traversal.addUndirectedEdge(1,2);
        traversal.addUndirectedEdge(3,4);
        traversal.addUndirectedEdge(1,5);
        traversal.addUndirectedEdge(2,6);
        traversal.addUndirectedEdge(3,6);
        traversal.addUndirectedEdge(6,7);
        traversal.addUndirectedEdge(3,7);
        traversal.addUndirectedEdge(4,7);
        traversal.addUndirectedEdge(7,8);
        traversal.addUndirectedEdge(4,8);


        traversal.bfs(2);
    }

    @Test
    public void testPrintPath() {
        Traversal traversal = new Traversal();

        traversal.addUndirectedEdge(1,2);
        traversal.addUndirectedEdge(3,4);
        traversal.addUndirectedEdge(1,5);
        traversal.addUndirectedEdge(2,6);
        traversal.addUndirectedEdge(3,6);
        traversal.addUndirectedEdge(6,7);
        traversal.addUndirectedEdge(3,7);
        traversal.addUndirectedEdge(4,7);
        traversal.addUndirectedEdge(7,8);
        traversal.addUndirectedEdge(4,8);

        traversal.printPath(2,8);
    }

}
