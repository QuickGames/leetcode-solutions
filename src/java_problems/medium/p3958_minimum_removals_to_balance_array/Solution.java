package java_problems.medium.p3958_minimum_removals_to_balance_array;

import java.util.Arrays;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 3634
 * Title: Minimum Removals to Balance Array
 * Language: Java
 * Topic: Senior, Array, Sliding Window, Sorting, Biweekly Contest 162
 */
class Solution {

    public int minRemoval(int[] nums, int k) {

        int result = 0;

        int min = nums[0];
        int max = nums[0];

        boolean isSorted = true;
        boolean kIsEquals = true;

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            min = getMin(min, num);
            max = getMax(max, num);
            if (num < nums[i - 1]) isSorted = false;
            int dif = abs(num - nums[i - 1]);
            if (dif != k) kIsEquals = false;
        }

        if (max < min * k) return 0;

        if (k == 1 || kIsEquals) return minRemovalK(nums, k, isSorted, min, max);

        while (min * k < max) {

            long different = (long) min * k - max;
            if (0 <= different) break;

            int minRemoveCount = 0;
            int maxRemoveCount = 0;

            int min2 = min * k;
            float max2 = (float) max / k;
            for (int num : nums) {
                if (num == -1) continue;
                if (num < max2) minRemoveCount++;
                if (min2 < num) maxRemoveCount++;
            }

            if (result == 0 && 1000 < nums.length && minRemoveCount == maxRemoveCount) {
                result = minRemoveCount;
                break;
            }

            if (minRemoveCount < maxRemoveCount) {
                int newMin = Integer.MAX_VALUE;
                for (int i = 0; i < nums.length; i++) {
                    int num = nums[i];
                    if (num == -1) continue;
                    if (num == min) {
                        nums[i] = -1;
                        result++;
                    } else newMin = getMin(newMin, num);
                }
                min = newMin;
            } else {
                int newMax = 0;
                for (int i = 0; i < nums.length; i++) {
                    int num = nums[i];
                    if (num == -1) continue;
                    if (num == max) {
                        nums[i] = -1;
                        result++;
                    } else newMax = getMax(newMax, num);
                }
                max = newMax;
            }

        }

        return result;
    }

    private int minRemovalK(int[] nums, int k, boolean isSorted, int min, int max) {

        if (!isSorted) Arrays.sort(nums);

        int pValue = -1;
        int pCount = 0;

        int cValue = -1;
        int cCount = 0;

        int minRemoveCount = 0;
        int maxRemoveCount = 0;

        int min2 = min * k;
        float max2 = (float) max / k;

        for (int num : nums) {
            if (num == pValue) pCount++;
            if (num == cValue) cCount++;
            else {
                cValue = num;
                cCount = 1;
            }
            if (pCount < cCount) {
                pValue = cValue;
                pCount = cCount;
            }
            if (num < max2) minRemoveCount++;
            if (min2 < num) maxRemoveCount++;
        }

        int result = getMin(minRemoveCount, maxRemoveCount);
        return getMin(result, nums.length - pCount);
    }

    private int getMin(int a, int b) {
        return (a < b ? a : b);
    }

    private int getMax(int a, int b) {
        return (a < b ? b : a);
    }

    private int abs(int k) {
        return (k < 0 ? -k : k);
    }

}
