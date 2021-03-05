package com.arjun.learn.algorithms.union;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class UnionOneDTest {

    @Test
    public void unionCreationTest() {
        UnionOneD union = new UnionOneD(8);

        // input graph
        int[][] edges = {
                {1,2},
                {3,4},
                {5,6},
                {7,8},
                {2,4},
                {2,5},
                {1,3},
                {6,8},
                {5,7}
        };

        // create union
        for(int[] edge : edges) {
            union.union(edge[0] - 1, edge[1] - 1);
        }

        // check the output
        int[] output = {-8,0,0,2,0,0,0,6};
        assertArrayEquals(union.getParent(), output);
    }
}
