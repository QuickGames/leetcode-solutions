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