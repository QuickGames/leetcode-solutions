class Solution {
    public int minOperations(String s) {
        int length = s.length();
        int count = 0;
        for (int i = 0; i < length; i++) count += (i ^ s.charAt(i)) & 1;
        return Math.min(count, length - count);
    }
}