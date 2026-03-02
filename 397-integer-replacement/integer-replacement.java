class Solution {
    
    public int integerReplacement(int n) {
        return longReplacement(n);
    }

    private int longReplacement(long n) {
        int result = 0;
        while (1 < n) {
            result++;
            if ((n & 1) == 1) {
                int r1 = longReplacement(n + 1);
                int r2 = longReplacement(n - 1);
                result += Math.min(r1, r2);
                break;
            } else n >>= 1;
        }
        return result;
    }

}