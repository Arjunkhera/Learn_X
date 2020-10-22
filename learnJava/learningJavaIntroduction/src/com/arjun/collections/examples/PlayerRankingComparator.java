package com.arjun.collections.examples;

import java.util.Comparator;

public class PlayerRankingComparator implements Comparator<Player> {
    @Override
    public int compare(Player first, Player second){
        return Integer.compare(first.getRanking(), second.getRanking());
    }
}
