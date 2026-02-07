package java_problems.medium.p1756_minimum_deletions_to_make_string_balanced;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 1653
 * Title: Minimum Deletions to Make String Balanced
 * Language: Java
 * Topic: Senior, String, Dynamic Programming, Stack, Biweekly Contest 39
 */
class Solution {

    public int minimumDeletions(String s) {
        if (s.length() == 1) return 0;
        int result = 0;

        char a = 'a';
        char b = 'b';

        int aMax = 0;
        int aCount = 0;
        int iMin = -1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == a) aCount++;
            else aCount--;
            if (aMax <= aCount) {
                aMax = aCount;
                iMin = i;
            }
        }
        for (int i = 0; i < iMin; i++) {
            if (s.charAt(i) == b) result++;
        }

        int bMax = 0;
        int bCount = 0;
        int iMax = s.length();

        for (int i = s.length() - 1; iMin < i; i--) {
            if (s.charAt(i) == b) bCount++;
            else bCount--;
            if (bMax <= bCount) {
                bMax = bCount;
                iMax = i;
            }
        }
        for (int i = s.length() - 1; i >= iMax; i--) {
            if (s.charAt(i) == a) result++;
        }

        System.out.println("s: " + s);
        System.out.println("iMin: " + iMin);
        System.out.println("iMax: " + iMax);
        System.out.println("result: " + result);

        return result;
    }

}
