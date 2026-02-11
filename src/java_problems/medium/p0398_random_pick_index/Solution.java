package java_problems.medium.p0398_random_pick_index;

import java.util.Random;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 398
 * Title: Random Pick Index
 * Language: Java
 * Topic: Junior, Hash Table, Math, Reservoir Sampling, Randomized
 */
class Solution {

    private Random random;
    private int[] nums;

    public Solution(int[] nums) {
        random = new Random();
        this.nums = nums;
    }

    public int pick(int target) {

        int[] indexes = new int[nums.length];
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                indexes[length] = i;
                length++;
            }
        }

        if (length == 0) return -1;
        if (length == 1) return indexes[0];
        int index = random.nextInt(length);
        return indexes[index];
    }

}

/*
  Your Solution object will be instantiated and called as such:
  Solution obj = new Solution(nums);
  int param_1 = obj.pick(target);
 */