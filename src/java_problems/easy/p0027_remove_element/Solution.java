package java_problems.easy.p0027_remove_element;

/**
 * @author QuickGames
 * Difficulty: Easy
 * Number: 27
 * Title: Remove Element
 * Language: Java
 * Topic: Array, Two Pointers
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i - result] = nums[i];
            if (nums[i] == val) {
                result++;
            }
        }
        return nums.length - result;
    }
}