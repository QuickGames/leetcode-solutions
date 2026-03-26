package java_problems.medium.p0128;

import java.util.Arrays;

/**
 * @author QuickGames
 * @Difficulty: Medium
 * @Number: 128
 * @Title: Longest Consecutive Sequence
 * @Language: Java
 * @Topic: Array, Hash Table, Union-Find
 */
class Solution {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);

        int result = 0;
        int count = 1;
        int last = nums[0];
        for (int num : nums) {
            if (num == last) continue;
            else if (num - last == 1) count++;
            else {
                result = Math.max(result, count);
                count = 1;
            }
            last = num;
        }
        return Math.max(result, count);
    }

}
