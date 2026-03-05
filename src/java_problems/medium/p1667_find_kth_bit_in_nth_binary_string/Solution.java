package java_problems.medium.p1667_find_kth_bit_in_nth_binary_string;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 1545
 * Title: Find Kth Bit in Nth Binary String
 * Language: Java
 * Topic: Senior, String, Recursion, Simulation, Weekly Contest 201
 */
class Solution {

    public char findKthBit(int n, int k) {
        String s = "0";
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < n; i++) {
            s = sb.append(s).append('1').append(inverse(s)).toString();
            sb.setLength(0);
            if (k <= s.length()) break;
        }

        return s.charAt(k - 1);
    }

    private String inverse(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; 0 <= i; i--) {
            if (chars[i] == '0') sb.append('1');
            else sb.append('0');
        }
        return sb.toString();
    }

}
