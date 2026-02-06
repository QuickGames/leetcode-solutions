package java_problems.easy.p0035_search_insert_position;

/**
 * @author QuickGames
 * Difficulty: Easy
 * Number: 35
 * Title: Search Insert Position
 * Language: Java
 * Topic: Array, Binary Search
 */
class Solution {

    public int searchInsert(int[] nums, int target) {

        if (target < nums[0]) return 0;
        if (nums[nums.length - 1] < target) return nums.length;

        int min = 0;
        int max = nums.length - 1;

        while (true) {
            int index = (max + min) / 2;
            int n = nums[index];
            if (n < target) {
                if (min == index) return max;
                else min = index;
            } else if (target < n) max = index;
            else return index;
        }

    }

}
