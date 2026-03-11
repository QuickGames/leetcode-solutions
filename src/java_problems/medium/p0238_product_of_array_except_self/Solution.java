package java_problems.medium.p0238_product_of_array_except_self;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 238
 * Title: Product of Array Except Self
 * Language: Java
 * Topic: Array, Prefix Sum
 */
class Solution {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int[] prefix = new int[nums.length];
        prefix[0] = 1;
        int[] suffix = new int[nums.length];
        suffix[nums.length - 1] = 1;

        for (int i = 0; i < nums.length - 1; i++)
            prefix[i + 1] = prefix[i] * nums[i];

        for (int i = nums.length - 1; 0 < i; i--)
            suffix[i - 1] = suffix[i] * nums[i];

        for (int i = 0; i < nums.length; i++)
            result[i] = prefix[i] * suffix[i];

        return result;
    }

}
