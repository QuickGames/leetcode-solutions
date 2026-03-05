class Solution {

    public int minOperations(String s) {
        char[] chars = s.toCharArray();
        int from1 = 0;
        int from0 = 0;
        for (int i = 0; i < chars.length; i++) {
            boolean isOdd = ((i & 1) == 1);
            if (isOdd) {
                from1 += (chars[i] == '0' ? 1 : 0);
                from0 += (chars[i] == '1' ? 1 : 0);
            } else {
                from1 += (chars[i] == '1' ? 1 : 0);
                from0 += (chars[i] == '0' ? 1 : 0);
            }
        }

        return chars.length - (from0 < from1 ? from1 : from0);
    }

}