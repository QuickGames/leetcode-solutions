package java_problems.easy.p0217_contains_duplicate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author QuickGames
 * Difficulty: Easy
 * Number: 217
 * Language: Java
 * Topic: Array, Hash Table, Sorting
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> buf = new HashMap<>();
        for (int value : nums) {
            int b = buf.getOrDefault(value, 0);
            if (b == 0) buf.put(value, 1);
            else return true;
        }
        return false;
    }
}