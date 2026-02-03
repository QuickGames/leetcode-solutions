class Solution {
    public int lengthOfLastWord(String s) {
        int result = 0;
        for (int i = s.length() - 1; 0 <= i; i--) {
            char symbal = s.charAt(i);
            if (symbal == ' ' && result != 0) break;
            if (symbal != ' ') result++;
        }
        return result;
    }
}