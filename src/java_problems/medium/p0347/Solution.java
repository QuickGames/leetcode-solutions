package java_problems.medium.p0347;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author QuickGames
 * @Difficulty: Medium
 * @Number: 347
 * @Title: Top K Frequent Elements
 * @Language: Java
 * @Topic: Array, Hash Table, Divide and Conquer, Sorting, Heap (Priority Queue), Bucket Sort, Counting, Quickselect
 */
class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }

        int[] result = new int[k + 1];
        int[] counts = new int[k + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getKey();
            int count = entry.getValue();

            for (int i = k - 1; 0 <= i; i--) {
                if (counts[i] < count) {
                    counts[i + 1] = counts[i];
                    counts[i] = count;
                    result[i + 1] = result[i];
                    result[i] = value;
                } else break;
            }

        }

        return Arrays.copyOf(result, k);
    }

}
