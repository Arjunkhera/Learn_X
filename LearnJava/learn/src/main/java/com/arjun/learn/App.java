package com.arjun.learn;


import java.io.IOException;
import java.util.*;

public class App {
    public static void main( String[] args ) throws IOException {

        Set<Integer> hello = new HashSet<>();
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        graph.computeIfAbsent(2, k -> new HashSet<Integer>()).add(3);
        int n = 6;
        System.out.println(n);
        System.out.println(n ^ ((1 << 32) - 1));
    }

    public void testing() {
        System.out.println(getSearchPath("/content/dam/a/b/c/d/e/de"));
        System.out.println(getSearchPath("/content/dam/de"));
        System.out.println(getSearchPath("/content/dam/a/de"));
    }

    public static String getSearchPath(String path) {
        String searchPath = "/content/dam/";
        String[] pathArray = path.split("/");

        int length = Math.max(3, pathArray.length - 3);
        if(length > 3) {
            StringJoiner joiner = new StringJoiner("/", "", "/");
            for(int i = 0; i < length; i++) {
                joiner.add(pathArray[i]);
            }
            searchPath = joiner.toString();
        }

        return searchPath;
    }

}