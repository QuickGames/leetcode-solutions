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