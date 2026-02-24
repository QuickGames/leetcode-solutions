package java_problems.medium.p1557_check_if_a_string_contains_all_binary_codes_of_size_k;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 1461
 * Title: Check If a String Contains All Binary Codes of Size K
 * Language: Java
 * Topic: Senior, Hash Table, String, Bit Manipulation, Rolling Hash, Hash Function, Biweekly Contest 27
 */
class Solution {

    public boolean hasAllCodes(String s, int k) {
        int[] includes = new int[(int) Math.pow(2, k)];
        for (int i = 0; i < s.length() - k + 1; i++) {
            String sub = s.substring(i, i + k);
            int index = Integer.parseInt(sub, 2);
            includes[index] = 1;
        }
        for (int include : includes) {
            if (include == 0) return false;
        }
        return true;
    }

}
