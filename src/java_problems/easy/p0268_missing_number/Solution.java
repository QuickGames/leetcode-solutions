package java_problems.easy.p0268_missing_number;

import java.util.Arrays;

/**
 * @author QuickGames
 * Difficulty: Easy
 * Number: 268
 * Language: Java
 * Topic: Array, Hash Table, Math, Binary Search, Bit Manipulation, Sorting
 */
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }
        return nums.length;
    }
}