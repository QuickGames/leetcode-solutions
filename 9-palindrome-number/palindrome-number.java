class Solution {
    public boolean isPalindrome(int x) {
        String source = "" + x;
        for (int i = 0; i < source.length() / 2; i++) {
            char s1 = source.charAt(i);
            char s2 = source.charAt(source.length() - 1 - i);
            if (s1 != s2) return false;
        }
        return true;
    }
}