package java_problems.medium.p0560;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 560
 * Title: Subarray Sum Equals K
 * Language: Java
 * Topic: Senior Staff, Array, Hash Table, Prefix Sum
 */
class Solution {

    public int subarraySum(int[] nums, int k) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum == k) result++;
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) result++;
            }
        }

        return result;
    }

    public int subarraySumWithoutNegatives(int[] nums, int k) {
        int result = 0;

        int left = 0;
        int right = 0;
        int sum = nums[0];
        while (left < nums.length) {
            if (sum == k) result++;
            if (sum < k && right + 1 < nums.length) {
                right++;
                sum += nums[right];
            } else if (k <= sum) {
                sum -= nums[left];
                left++;
            } else break;
        }

        return result;
    }

}
