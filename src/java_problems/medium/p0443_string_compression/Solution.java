package java_problems.medium.p0443_string_compression;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 443
 * Title: String Compression
 * Language: Java
 * Topic: Senior, Two Pointers, String
 */
class Solution {

    public int compress(char[] chars) {
        char[] result = new char[2000];
        int resultCount = 0;

        int count = 1;
        char last = chars[0];
        for (int i = 1; i < chars.length; i++) {
            char cur = chars[i];
            if (last != cur) {
                resultCount = upgradeResult(result, last, count, resultCount);
                count = 1;
            } else count++;
            last = cur;
        }

        resultCount = upgradeResult(result, last, count, resultCount);
        resultCount = Math.min(resultCount, chars.length);
        for (int i = 0; i < resultCount; i++) chars[i] = result[i];

        return resultCount;
    }

    private int upgradeResult(char[] result, char c, int count, int resultCount) {
        result[resultCount] = c;
        resultCount++;
        int addResultCount = 0;
        char[] counter = new char[10];
        if (1 < count)
            while (0 < count) {
                counter[addResultCount] = (char) ((count % 10) + 48);
                addResultCount++;
                count /= 10;
            }
        for (int i = addResultCount - 1; 0 <= i; i--) {
            result[resultCount] = counter[i];
            resultCount++;
        }
        return resultCount;
    }

}
