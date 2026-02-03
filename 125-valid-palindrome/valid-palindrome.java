class Solution {

    private String symbols = "abcdefghijklmnopqrstuvwxyz0123456789";

    public boolean isPalindrome(String s) {
        String result = "";
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            String symbol = s.substring(i, i + 1);
            if (-1 < symbols.indexOf(symbol)) {
                result += symbol;
            }
        }
        for (int i = 0; i < result.length(); i++) {
            String s1 = result.substring(i, i + 1);
            String s2 = result.substring(result.length() - i - 1, result.length() - i);
            if (!s1.equals(s2)) return false;
        }
        return true;
    }

}