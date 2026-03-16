package java_problems.hard.p0060;

/**
 * @author QuickGames
 * Difficulty: Hard
 * Number: 60
 * Title: Permutation Sequence
 * Language: Java
 * Topic: Math, Recursion
 */
class Solution {

    public String getPermutation(int n, int k) {

        int[] digits = new int[n];
        for (int i = 0; i < n; i++) digits[i] = i + 1;

        int exp = 1;
        for (int i = 2; i < n; i++) exp *= i;

        StringBuilder result = new StringBuilder();
        k--;
        for (int i = 0; i < n; i++) {
            if (0 < exp) {
                int index = k / exp;
                result.append(digits[index]);
                digits = updateDigits(digits, index);
                if (digits.length == 0) break;
                k %= exp;
                exp /= digits.length;
            } else {
                for (int j = 0; j < n; j++)
                    result.append(digits[j]);
                break;
            }
        }

        return result.toString();
    }

    private int[] updateDigits(int[] digits, int index) {
        int[] result = new int[digits.length - 1];
        int add = 0;
        for (int i = 0; i < result.length; i++) {
            if (index <= i) add = 1;
            result[i] = digits[i + add];
        }
        return result;
    }

}
