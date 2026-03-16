package java_problems.medium.p2110;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 2110
 * Title: Number of Smooth Descent Periods of a Stock
 * Language: Java
 * Topic: Staff, Array, Math, Two Pointers, Dynamic Programming, Sliding Window, Weekly Contest 272
 */
class Solution {

    public long GetDescentPeriods(int[] prices) {
        long result = 1;

        long current = 1;
        int last = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (last - prices[i] == 1) current++;
            else current = 1;
            result += current;
            last = prices[i];
        }

        return result;
    }

}
