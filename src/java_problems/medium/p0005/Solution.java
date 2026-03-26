package java_problems.medium.p0005;

/**
 * @author QuickGames
 * @Difficulty: Medium
 * @Number: 5
 * @Title: Longest Palindromic Substring
 * @Language: Java
 * @Topic: Two Pointers, String, Dynamic Programming
 */
class Solution {

    public String longestPalindrome(String s) {
        String result = "";
        int resultLength = 0;

        for (int left = 0; left < s.length(); left++) {
            for (int right = s.length() - 1; left <= right && resultLength < right - left + 1; right--) {

                int subLength = right - left + 1;
                boolean isPalindrome = true;
                for (int i = 0; i < subLength / 2; i++) {
                    if (s.charAt(left + i) != s.charAt(right - i)) {
                        isPalindrome = false;
                        break;
                    }
                }

                if (isPalindrome && resultLength < subLength) {
                    result = s.substring(left, right + 1);
                    resultLength = subLength;
                }

            }
        }

        return result;
    }

}
