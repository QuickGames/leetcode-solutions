package java_problems.easy.p1884_minimum_changes_to_make_alternating_binary_string;

/**
 * @author QuickGames
 * Difficulty: Easy
 * Number: 1758
 * Title: Minimum Changes To Make Alternating Binary String
 * Language: Java
 * Topic: Mid Level, String, Weekly Contest 228
 */
class Solution {

    public int minOperations(String s) {
        int length = s.length();
        int count = 0;
        for (int i = 0; i < length; i++) count += (i ^ s.charAt(i)) & 1;
        return Math.min(count, length - count);
    }

}
