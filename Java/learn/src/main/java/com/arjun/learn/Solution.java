package com.arjun.learn;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < testCases; i++) {
            Union union = new Union(26);
            String input = scanner.next();

            int ops = scanner.nextInt();
            for(int j = 0; j < ops; j++) {
                String first = scanner.next();
                String second = scanner.next();

                union.combine(first.charAt(0) - 'a', second.charAt(0) - 'a');
            }

            Set<Integer> parents = new HashSet<>();
            for(Character ch : input.toCharArray()) {
                parents.add(union.find(ch - 'a'));
            }

            if (parents.size() > 1) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }

    static class Union {

        private final int[] parent;

        public Union(int capacity) {
            this.parent = new int[capacity];

            for (int i = 0; i < capacity; i++) {
                this.parent[i] = -1;
            }
        }

        public void combine(int a, int b) {
            int parentA = find(a);
            int parentB = find(b);

            // nodes are in same set
            if (parentA == parentB) {
                return;
            }

            // merge according to ranks
            int rankA = parent[parentA];
            int rankB = parent[parentB];
            if (rankA <= rankB) {
                parent[parentA] = rankA + rankB;
                parent[parentB] = parentA;
            } else {
                parent[parentB] = rankA + rankB;
                parent[parentA] = parentB;
            }
        }

        public int find(int node) {
            if (parent[node] < 0) {
                return node;
            }
            // compress the path
            return parent[node] = find(parent[node]);
        }
    }
}