package java_problems.medium.p3719;

import java.util.ArrayList;
import java.util.List;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 3719
 * Title: Longest Balanced Subarray I
 * Language: Java
 * Topic: Senior, Array, Hash Table, Divide and Conquer, Segment Tree, Prefix Sum, Weekly Contest 472
 */
class Solution {

    public int longestBalanced(int[] nums) {

        List<SubArray> subArrays = new ArrayList<>();

        for (int n : nums) {
            for (SubArray subArray : subArrays) subArray.next(n);
            subArrays.add(new SubArray(n));
        }

        int result = 0;
        for (SubArray subArray : subArrays) result = max(result, subArray.getResult());
        return result;
    }

    private int max(int a, int b) {
        return a < b ? b : a;
    }

}
