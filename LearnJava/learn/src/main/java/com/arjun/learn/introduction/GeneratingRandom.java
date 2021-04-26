package com.arjun.introduction;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class GeneratingRandom {
    public static void main(String[] args) {

    }

    public static void generatingRandom(int min, int max) {
        int randomWithMathRandom = (int) ((Math.random() * (max - min)) + min);

        Random random = new Random();
        int randomWithNextInt = random.nextInt();
        int randomWithNextIntWithinARange = random.nextInt(max - min) + min;

        int streamSize = 5;
        IntStream unlimitedIntStream = random.ints();
        IntStream limitedIntStream = random.ints(streamSize);
        IntStream limitedIntStreamWithinARange = random.ints(streamSize, min, max);

        int randomWithThreadLocalRandomInARange = ThreadLocalRandom.current().nextInt(min, max);
        int randomWithThreadLocalRandom = ThreadLocalRandom.current().nextInt();
        int randomWithThreadLocalRandomFromZero = ThreadLocalRandom.current().nextInt(max);
        IntStream streamWithThreadLocalRandom = ThreadLocalRandom.current().ints();
    }

}
