package java_problems.hard.p2472;

/**
 * @author QuickGames
 * @Difficulty: Hard
 * @Number: 2472
 * @Title: Maximum Number of Non-overlapping Palindrome Substrings
 * @Language: Java
 * @Topic: Senior Staff, Two Pointers, String, Dynamic Programming, Greedy, Weekly Contest 319
 */
class Solution {

    public int maxPalindromes(String s, int k) {
        int[][] polis = new int[s.length() / k][2];
        int polisCount = 0;

        for (int i = 0; i < s.length() - k + 1; i++) {
            int left = i;
            int right = left + k;
            while (right <= s.length()) {
                String sub = s.substring(left, right);
                boolean isPalindrome = true;
                for (int j = 0; j < sub.length() / 2; j++) {
                    if (sub.charAt(j) != sub.charAt(sub.length() - j - 1)) {
                        isPalindrome = false;
                        break;
                    }
                }
                if (isPalindrome) {
                    while (0 < polisCount && right < polis[polisCount - 1][1]
                            && (polis[polisCount - 1][0] <= left && right <= polis[polisCount - 1][1]
                            || 1 < polisCount
                            && (left <= polis[polisCount - 2][0]
                            || polis[polisCount - 2][0] <= left && right <= polis[polisCount - 2][1])
                            || polisCount == 1))
                        polisCount--;
                    if (0 < polisCount && polis[polisCount - 1][1] <= left || polisCount == 0) {
                        polis[polisCount++] = new int[]{left, right};
                        left = right;
                        right += k - 1;
                    }
                }
                right++;
            }
            if (s.length() / k == polisCount) break;
        }

        return polisCount;
    }

}
