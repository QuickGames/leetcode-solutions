package java_problems.easy.p3172_divisible_and_non_divisible_sums_difference;

/**
 * @author QuickGames
 * Difficulty: Easy
 * Number: 2894
 * Title: Divisible and Non-divisible Sums Difference
 * Language: Java
 * Topic: Mid Level, Math, Weekly Contest 366
 */
class Solution {
    public int differenceOfSums(int n, int m) {
        int num1 = 0;
        int num2 = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                num2 += i;
            } else {
                num1 += i;
            }
        }
        return num1 - num2;
    }
}