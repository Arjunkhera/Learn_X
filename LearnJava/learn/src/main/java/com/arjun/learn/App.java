package com.arjun.learn;


import java.io.IOException;
import java.util.*;

public class App {
    public static void main( String[] args ) throws IOException {
        int[] intArray = new int[10];
        int[] initialize = {1,2,3};

        boolean[] booleanArray = {false, true};
        char[] charArray = {'a'};
        Integer[] IntegerArray = new Integer[0];
        System.out.println(IntegerArray.length);

        int[][] twoDArray = new int[2][];
        for(int i = 0; i < twoDArray.length; i++)
            twoDArray[i] = new int[3];
        int[][] initTwoD = {
                {1,2},
                {3,4}
        };

    }

    public void sorting() {
        int[] arr = new int[] {1,2,3};

        int[][] rooms = {{7,14},{11,6},{3,1},{9,4},{14,14},{17,11},{22,13},{6,25},{12,22},{21,9}};
        int[][] queries = {{21,17},{4,6},{17,25},{15,18},{17,16},{18,16},{8,17},{6,7},{9,22},{17,18}};

        for(var room: rooms)
            System.out.printf("[%d:%d],", room[0], room[1]);
        System.out.println("\n------------");

        int[][] ascending = Arrays.stream(rooms).map(int[]::clone).toArray(int[][]::new);
        Arrays.sort(ascending, Comparator.comparingInt(a -> a[1]));
        for(var room: ascending)
            System.out.printf("[%d:%d],", room[0], room[1]);
        System.out.println("\n------------");

        int[][] descending = Arrays.stream(rooms).map(int[]::clone).toArray(int[][]::new);
        Arrays.sort(descending, (a, b) -> Integer.compare(b[1], a[1]));
        for(var room: descending)
            System.out.printf("[%d:%d],", room[0], room[1]);
        System.out.println("\n------------");
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