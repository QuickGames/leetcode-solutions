class Solution {
    public int maximum69Number (int num) {
        int lastN10 = 10000;
        for (int i = 3; 0 <= i; i--) {
            int n10 = pow10(i);
            int numPart = num % lastN10;
            int n = numPart / n10;
            if (n == 6) {
                num += n10 * 3;
                break;
            }
            lastN10 = n10;
        }
        return num;
    }
    
    private int pow10(int level) {
        int result = 1;
        for (int i = 0; i < level; i++) result *= 10;
        return result;
    }

}