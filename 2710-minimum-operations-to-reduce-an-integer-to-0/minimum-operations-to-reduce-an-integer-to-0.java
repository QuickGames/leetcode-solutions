class Solution {
    
    public int minOperations(int n) {
        int result = 0;
        for (int i = 17; 0 <= i; i--) {
            int down2 = pow2(i - 1);
            if (n < down2) continue;
            int up = Math.abs(pow2(i) - n);
            int down = Math.abs(down2 - n);
            n = Math.min(down, up);
            result++;
            if (n == 0) break;
        }
        return result;
    }

    private int pow2(int exponent) {
        int result = 1;
        for (int i = 0; i < exponent; i++) result *= 2;
        return result;
    }

}