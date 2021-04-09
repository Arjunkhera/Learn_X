package com.arjun.learn;

import com.arjun.learn.algorithms.graphs.Traversal;
import com.arjun.learn.algorithms.graphs.TraversalString;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main( String[] args ) throws IOException {
        testing();
    }

    public static void testing() {
        String path1= "/content/dam/we-retail/en/a";
        String path2= "/content/dam/en/";
        String path3= "/content/dam/we-retail/a/a/en/c";

        String prefix = "/content/dam/";
        String[] result = path1.split("/");
        for(String res: result) {
            System.out.println(res);
        }
        System.out.println(String.join(":", result));
    }
}