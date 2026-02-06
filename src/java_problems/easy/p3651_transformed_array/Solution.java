package java_problems.easy.p3651_transformed_array;

/**
 * @author QuickGames
 * Difficulty: Easy
 * Number: 3379
 * Title: Transformed Array
 * Language: Java
 * Topic: Mid Level, Array, Simulation, Weekly Contest 427
 */
class Solution {

    public int[] constructTransformedArray(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i] + i;
            while (n < 0) n += nums.length;
            while (nums.length <= n) n -= nums.length;
            result[i] = nums[n];
        }
        return result;
    }

}
