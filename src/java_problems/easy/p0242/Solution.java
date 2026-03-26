package java_problems.easy.p0242;

import java.util.Arrays;

/**
 * @author QuickGames
 * @Difficulty: Easy
 * @Number: 242
 * @Title: Valid Anagram
 * @Language: Java
 * @Topic: Hash Table, String, Sorting
 */
class Solution {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] sc = s.toCharArray();
        Arrays.sort(sc);
        char[] tc = t.toCharArray();
        Arrays.sort(tc);

        for (int i = 0; i < s.length(); i++)
            if (sc[i] != tc[i]) return false;

        return true;
    }

}
