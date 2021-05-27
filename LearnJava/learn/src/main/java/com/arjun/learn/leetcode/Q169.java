package com.arjun.learn.leetcode;

public class Q169 {

    public int usingBitManipulation(int[] nums) {
        int[] bits = new int[32];

        for(int num : nums)
            for(int i = 0; i < 32; i++)
                bits[32-i-1] += (num>>i) & 1;

        int answer = 0;
        for(int i = 0; i < 32; i++)
            answer = answer<<1 | (bits[i] > nums.length/2 ? 1 : 0);
        return answer;
    }

    public int boothsAlgorithm(int[] nums) {
        int answer = 0, count = 0;
        for(int num : nums) {
            if (count == 0)
                answer = num;
            count += (num == answer ? 1 : -1);
        }

        return answer;
    }
}
