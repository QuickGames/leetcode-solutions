package java_problems.medium.p1209;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 1209
 * Title: Remove All Adjacent Duplicates in String II
 * Language: Java
 * Topic: Staff, String, Stack, Weekly Contest 156
 */
class Solution {

    public String removeDuplicates(String s, int k) {
        String str = s;

        int left = 0;
        int right = 1;
        char c = str.charAt(0);
        int count = 1;
        while (left < str.length() && k <= str.length()) {
            while (0 < left && str.charAt(left - 1) == c) {
                left--;
                count++;
            }
            if (str.length() <= right) break;
            char next = str.charAt(right);
            if (c != next) {
                if (k <= count) {
                    count = count / k * k;
                    str = cutStr(str, left, count);
                    right -= count;
                }
                left = right;
                c = next;
                count = 1;
            } else count++;
            right++;
        }

        if (k <= count) {
            count = count / k * k;
            str = cutStr(str, left, count);
        }

        return str;
    }

    private String cutStr(String s, int index, int count) {
        if (index == 0) return s.substring(count);
        else return s.substring(0, index) + s.substring(index + count);
    }

}
