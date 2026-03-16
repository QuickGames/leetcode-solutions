package java_problems.medium.p1004;

/**
 * @author QuickGames
 * @Difficulty: Medium
 * @Number: 1004
 * @Title: Max Consecutive Ones III
 * @Language: Java
 * @Topic: Senior Staff, Array, Binary Search, Sliding Window, Prefix Sum, Weekly Contest 126
 */
class Solution {

    public int longestOnes(int[] nums, int k) {
        int result = 0;

        int left = 0;
        int right = 0;

        int health = k;

        int count = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                if (0 < health) {
                    health--;
                    count++;
                    right++;
                    result = Math.max(result, count);
                } else if (nums[left] == 0) {
                    health++;
                    count--;
                    left++;
                } else {
                    count--;
                    left++;
                }
            } else {
                right++;
                count++;
                result = Math.max(result, count);
            }
        }

        return result;
    }

}
