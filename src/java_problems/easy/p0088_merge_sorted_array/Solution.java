package java_problems.easy.p0088_merge_sorted_array;

/**
 * @author QuickGames
 * Difficulty: Easy
 * Number: 88
 * Title: Merge Sorted Array
 * Language: Java
 * Topic: Array, Two Pointers, Sorting
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m;
        int j = n;
        while (0 < j) {
            if (i <= 0 || nums1[i - 1] < nums2[j - 1]) {
                nums1[i + j - 1] = nums2[j - 1];
                j--;
            } else {
                nums1[i + j - 1] = nums1[i - 1];
                nums1[i - 1] = 0;
                i--;
            }
        }
    }
}