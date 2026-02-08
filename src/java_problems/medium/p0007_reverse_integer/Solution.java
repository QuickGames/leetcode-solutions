package java_problems.medium.p0007_reverse_integer;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 7
 * Title: Reverse Integer
 * Language: Java
 * Topic: Math
 */
class Solution {
    public int reverse(int x) {
        int isN = (x < 0 ? -1 : 1);
        StringBuilder sb = new StringBuilder();
        sb.append("" + x);
        sb.reverse();
        String s = sb.toString().replace("-", "");
        try {
            return Integer.valueOf(s) * isN;
        } catch (Exception e) {
            return 0;
        }
    }
}