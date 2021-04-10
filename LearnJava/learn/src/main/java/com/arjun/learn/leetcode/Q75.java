package com.arjun.learn.leetcode;

public class Q75 {
    public static void first(int[] nums) {
        int z = -1, o = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 2)
                continue;
            if(nums[i] == 1) {
                nums[i] = 2;
                nums[++o] = 1;
            } else if (nums[i] == 0) {
                nums[i] = 2;
                nums[++o] = 1;
                nums[++z] = 0;
            }
        }
    }

    public static void second(int[] nums) {
        int j = 0, k = nums.length - 1;
        for(int i = 0; i <= k; i++) {
            if(nums[i] == 0) {
                nums[i] = nums[j];
                nums[j++] = 0;
            } else if(nums[i] == 2) {
                nums[i--] = nums[k];
                nums[k--] = 2;
            }
        }
    }
}
