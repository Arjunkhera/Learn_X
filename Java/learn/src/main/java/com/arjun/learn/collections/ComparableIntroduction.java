package com.arjun.learn.collections;

import com.arjun.learn.collections.examples.Player;
import com.arjun.learn.collections.examples.PlayerRankingComparator;

import java.util.*;

public class ComparableIntroduction {

    public static void main(String[] args) {
        List<Player> footballTeam = new ArrayList<>();
        Player player1 = new Player(59, "John", 20);
        Player player2 = new Player(67, "Roger", 22);
        Player player3 = new Player(45, "Steven", 24);
        footballTeam.add(player1);
        footballTeam.add(player2);
        footballTeam.add(player3);

        // Using comparable : declared inside the class
        Collections.sort(footballTeam);

        // Using comparator class declared separately
        PlayerRankingComparator playerRankingComparator = new PlayerRankingComparator();
        Collections.sort(footballTeam, playerRankingComparator);
        // java 8 adds sort to List interface directly instead of requiring use of collections
        // we will be using List.sort from now on
        footballTeam.sort(playerRankingComparator);

        // we can use anonymous class instead
        footballTeam.sort(new Comparator<>() {
            @Override
            public int compare(Player first, Player second) {
                return Integer.compare(first.getRanking(), second.getRanking());
            }
        });
        // or we can directly use lambda's
        footballTeam.sort((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));
        // which can be replaced further with method reference is logic is using class methods
        footballTeam.sort(Comparator.comparingInt(Player::getAge));


        // fyi : lamda declarations can be done outside as well
        // subtraction is not preferred since it can lead to integer overflow
        Comparator<Player> rankingComparator = (p1, p2) -> p1.getRanking() - p2.getRanking();
        // another example, but with method reference
        Comparator<Player> ageComparator = Comparator.comparing(Player::getAge);
    }

    public static void comparatorsForPrimitives() {
        int[] oneDimensionalArray = new int[25];
        // Ascending order
        Arrays.sort(oneDimensionalArray);
        // Descending order ?
        // Arrays.sort(oneDimensionalArray, (x, y) -> y - x); // throws error
        // manually reverse sorted array for descending order

        // Comparators require Objects
        int[][] twoDimensionalArray = new int[26][2];
        // works because int[] is an Object
        Arrays.sort(twoDimensionalArray, (x, y) -> y[0] - x[0]);

        Integer[] wrapperArray = new Integer[26];
        // Remember, unlike int arrays, Objects are initialized with null values
        System.out.println(wrapperArray[2] == null ? "true" : "false");
    }

}
