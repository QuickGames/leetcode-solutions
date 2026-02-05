package java_problems.easy.p3379_score_of_a_string;

/**
 * @author QuickGames
 * Difficulty: Easy
 * Number: 3110
 * Title: Score of a String
 * Language: Java
 * Topic: Mid Level, String, Biweekly Contest 128
 */
class Solution {
    public int scoreOfString(String s) {
        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int value = Math.abs(s.charAt(i) - s.charAt(i + 1));
            result += value;
        }
        return result;
    }
}