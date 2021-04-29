package com.arjun.learn;


import java.io.IOException;
import java.util.*;

public class App {
    public static void main( String[] args ) throws IOException {
        testing();
    }


    public static void testing() {
        int[][] check = new int[][] {
                {3,2,1},
                {14,1,10},
                {1,6,2}
        };

        Arrays.sort(check[2]);

        System.out.println("Hello");
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