package java_problems.medium.p3714;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 3714
 * Title: Longest Balanced Substring II
 * Language: Java
 * Topic: Staff, Hash Table, String, Prefix Sum, Weekly Contest 471
 */
class Solution {

    public int longestBalanced(String s) {

        if (s.isEmpty() || s.length() == 1) return s.length();

        int leftIndex = 0;
        int rightIndex = 0;

        int countChars = 0;
        int maxCharsInGroup = 0;
        int[] chars = new int[3];

        int bestCountChars = 0;
        int bestMaxCharsInGroup = 0;
        int[] bestChars = new int[3];

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
                    System.arraycopy(chars, 0, bestChars, 0, chars.length);
                    result = max(result, bestCountChars);
                }

            }

            if (bestCountChars == 0) {
                rightIndex++;
                leftIndex++;
                continue;
            }

            if (s.length() - leftIndex + 1 <= result) break;

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
            System.arraycopy(bestChars, 0, chars, 0, bestChars.length);

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
        return chars[0] == chars[1] && chars[2] == count;
    }

    private int max(int a, int b) {
        return a < b ? b : a;
    }

}
