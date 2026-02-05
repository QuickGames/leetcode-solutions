package java_problems.easy.p0058_length_of_last_word;

/**
 * @author QuickGames
 * Difficulty: Easy
 * Number: 58
 * Title: Length of Last Word
 * Language: Java
 * Topic: String
 */
class Solution {
    public int lengthOfLastWord(String s) {
        int result = 0;
        for (int i = s.length() - 1; 0 <= i; i--) {
            char symbol = s.charAt(i);
            if (symbol == ' ' && result != 0) break;
            if (symbol != ' ') result++;
        }
        return result;
    }
}