package com.arjun.learn.leetcode;

import java.util.Arrays;
import java.util.TreeSet;

public class Q1847 {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        int[] res = new int[queries.length];
        int[][] q = new int[queries.length][];
        for(int i = 0; i < queries.length; i++)
            q[i] = new int[] {queries[i][0], queries[i][1], i};

        Arrays.sort(rooms, (a, b) -> b[1] - a[1]);
        Arrays.sort(q, (a,b) -> b[1] - a[1]);
        TreeSet<Integer> ids = new TreeSet<Integer>();
        int rid = 0;

        for(var row : q) {
            for(; rid < rooms.length && rooms[rid][1] >= row[1]; rid++)
                ids.add(rooms[rid][0]);

            Integer low = ids.floor(row[0]), high = ids.ceiling(row[0]);
            if(low != null && high != null)
                res[row[2]] = (row[0] - low) <= (high - row[0]) ? low : high;
            else
                res[row[2]] = low == null && high == null ? -1 : low == null ? high : low;
        }
        return res;
    }
}
