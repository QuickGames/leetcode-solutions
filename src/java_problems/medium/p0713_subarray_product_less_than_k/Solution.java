package java_problems.medium.p0713_subarray_product_less_than_k;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 713
 * Title: Subarray Product Less Than K
 * Language: Java
 * Topic: Principal, Array, Binary Search, Sliding Window, Prefix Sum
 */
class Solution {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (current < k) result++;
            else continue;
            for (int j = i + 1; j < nums.length; j++) {
                current *= nums[j];
                if (current < k) result++;
                else break;
            }
        }
        return result;
    }

}
