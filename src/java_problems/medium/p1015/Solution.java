package java_problems.medium.p1015;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 1015
 * Title: Smallest Integer Divisible by K
 * Language: Java
 * Topic: Senior, Hash Table, Math, Weekly Contest 129
 */
class Solution {

    public int smallestRepunitDivByK(int k) {
        if ((k & 1) == 0 || k % 10 == 5) return -1;
        int n = 1;
        int result = 1;
        while (0 < n % k) {
            result++;
            n = (n * 10 + 1) % k;
        }
        return result;
    }

}
