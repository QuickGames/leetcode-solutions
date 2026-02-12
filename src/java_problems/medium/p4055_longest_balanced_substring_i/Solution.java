package java_problems.medium.p4055_longest_balanced_substring_i;

import java.util.Arrays;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 3713
 * Title: Longest Balanced Substring I
 * Language: Java
 * Topic: Senior, Hash Table, String, Counting, Enumeration, Weekly Contest 471
 */
class Solution {

    public int longestBalanced(String s) {

        if (s.isEmpty() || s.length() == 1) return s.length();

        int leftIndex = 0;
        int rightIndex = 0;

        int countChars = 0;
        int maxCharsInGroup = 0;
        int[] chars = new int[26];

        int bestCountChars = 0;
        int bestMaxCharsInGroup = 0;
        int[] bestChars = new int[26];

        int result = 0;

        while (leftIndex < s.length()) {

            for (int i = rightIndex; i < s.length(); i++) {
                char c = s.charAt(i);
                int count = charsGet(chars, c);
                maxCharsInGroup = max(maxCharsInGroup, count + 1);
                charsInc(chars, c);
                countChars++;

                if (bestCountChars < countChars && allCharsCountEquals(chars, maxCharsInGroup)) {
                    bestCountChars = countChars;
                    bestMaxCharsInGroup = maxCharsInGroup;
                    bestChars = Arrays.copyOf(chars, chars.length);
                    result = max(result, bestCountChars);
                }

            }

            if (bestCountChars == 0) {
                rightIndex++;
                leftIndex++;
                continue;
            }

            rightIndex = leftIndex + bestCountChars;

            char c = s.charAt(leftIndex);
            charsDec(bestChars, c);
            bestCountChars--;
            if (bestCountChars == 0) bestMaxCharsInGroup = 0;
            else if (bestCountChars == 1) bestMaxCharsInGroup = 1;
            else if (1 < bestMaxCharsInGroup)
                bestMaxCharsInGroup = getMaxCount(bestChars);
            leftIndex++;

            countChars = bestCountChars;
            maxCharsInGroup = bestMaxCharsInGroup;
            chars = Arrays.copyOf(bestChars, bestChars.length);

        }

        return result;
    }

    private int getMaxCount(int[] chars) {
        int result = 0;
        for (int c : chars) result = max(result, c);
        return result;
    }

    private int charsGet(int[] chars, char c) {
        return chars[c - 97];
    }

    private void charsDec(int[] chars, char c) {
        chars[c - 97]--;
    }

    private void charsInc(int[] chars, char c) {
        chars[c - 97]++;
    }

    private boolean allCharsCountEquals(int[] chars, int count) {
        for (int c : chars) if (c != 0 && c != count) return false;
        return true;
    }

    private int max(int a, int b) {
        return a < b ? b : a;
    }

}
