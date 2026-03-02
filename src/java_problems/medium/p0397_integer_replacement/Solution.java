package java_problems.medium.p0397_integer_replacement;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 397
 * Title: Integer Replacement
 * Language: Java
 * Topic: Junior, Dynamic Programming, Greedy, Bit Manipulation, Memoization
 */
class Solution {

    public int integerReplacement(int n) {
        return longReplacement(n);
    }

    private int longReplacement(long n) {
        int result = 0;
        while (1 < n) {
            result++;
            if ((n & 1) == 1) {
                int r1 = longReplacement(n + 1);
                int r2 = longReplacement(n - 1);
                result += Math.min(r1, r2);
                break;
            } else n >>= 1;
        }
        return result;
    }

}
