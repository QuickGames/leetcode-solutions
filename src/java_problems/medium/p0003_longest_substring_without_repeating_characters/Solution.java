package java_problems.medium.p0003_longest_substring_without_repeating_characters;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 3
 * Title: Longest Substring Without Repeating Characters
 * Language: Java
 * Topic: Staff, Hash Table, String, Sliding Window
 */
class Solution {

    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        char[] chars = s.toCharArray();

        int[] count = new int[255];
        int left = 0;
        int right = 0;
        int length = 0;
        while (right < chars.length) {
            char c = chars[right];
            if (count[c] != 0) {
                while (left <= right) {
                    char cl = chars[left];
                    count[cl]--;
                    length--;
                    left++;
                    if (cl == c) break;
                }
            }
            length++;
            count[c]++;
            right++;
            result = Math.max(result, length);
        }

        return result;
    }

}
