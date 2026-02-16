package java_problems.medium.p4056_longest_balanced_substring_ii;

import java.util.HashMap;

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

        int result = longestBalancedOne(s);
        if (result == s.length()) return result;
        if (2 < s.length()) result = max(result, longestBalancedABC(s));
        if (result == s.length()) return result;
        result = max(result, longestBalancedAB(s, 'a', 'b'));
        if (result == s.length()) return result;
        result = max(result, longestBalancedAB(s, 'a', 'c'));
        if (result == s.length()) return result;
        result = max(result, longestBalancedAB(s, 'b', 'c'));
        return result;
    }

    private int longestBalancedOne(String s) {
        char current = 'a';
        int count = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == current){
                count++;
            }else {
                result = max(result, count);
                count = 1;
                current = c;
            }
        }

        return max(result, count);
    }

    private int longestBalancedAB(String s, char charA, char charB) {

        HashMap<Integer, Integer> prefixSums = new HashMap<>();

        prefixSums.put(0, -1);

        int countA = 0;
        int countB = 0;

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == charA) countA++;
            else if (c == charB) countB++;
            else {
                countA = 0;
                countB = 0;
                prefixSums = new HashMap<>();
                prefixSums.put(0, i);
            }
            int key = countA - countB;
            int value = prefixSums.getOrDefault(key, -2);
            if (value == -2) prefixSums.put(key, i);
            else result = max(result, i - value);
        }

        return result;
    }

    private int longestBalancedABC(String s) {

        HashMap<String, Integer> prefixSums = new HashMap<>();

        prefixSums.put("0_0", -1);

        int countA = 0;
        int countB = 0;
        int countC = 0;

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'a' -> countA++;
                case 'b' -> countB++;
                case 'c' -> countC++;
            }
            String key = (countA - countB) + "_" + (countB - countC);
            int value = prefixSums.getOrDefault(key, -2);
            if (value == -2) prefixSums.put(key, i);
            else result = max(result, i - value);
        }

        return result;
    }

    private int max(int a, int b) {
        return a < b ? b : a;
    }

}
