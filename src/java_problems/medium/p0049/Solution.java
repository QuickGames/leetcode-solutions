package java_problems.medium.p0049;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author QuickGames
 * @Difficulty: Medium
 * @Number: 49
 * @Title: Group Anagrams
 * @Language: Java
 * @Topic: Array, Hash Table, String, Sorting
 */
class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        List<int[]> keys = new ArrayList<>();

        for (String str : strs) {

            int[] hash = new int[26];
            for (int j = 0; j < str.length(); j++)
                hash[str.charAt(j) - 97]++;

            boolean isUnique = true;
            for (int j = 0; j < keys.size(); j++) {
                if (Arrays.equals(hash, keys.get(j))) {
                    result.get(j).add(str);
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                List<String> next = new ArrayList<>();
                keys.add(hash);
                next.add(str);
                result.add(next);
            }

        }

        return result;
    }

}
