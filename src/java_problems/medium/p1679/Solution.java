package java_problems.medium.p1679;

import java.util.Arrays;

/**
 * @author QuickGames
 * @Difficulty: Medium
 * @Number: 1679
 * @Title: Max Number of K-Sum Pairs
 * @Language: Java
 * @Topic: Senior, Array, Hash Table, Two Pointers, Sorting, Weekly Contest 218
 */
class Solution {

    public int maxOperations(int[] nums, int k) {
        int result = 0;
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < k) left++;
            else if (k < sum) right--;
            else {
                result++;
                left++;
                right--;
            }
        }

        return result;
    }

}
