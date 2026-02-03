package medium.p50_powx_n;

/**
 * @author QuickGames
 * Topic: Math, Recursion
 */
class Solution {
    public double myPow(double x, int n) {
        double result = 1d;
        long nl = Math.abs((long) n);
        while (0 < nl) {
            if (nl % 2 == 1) {
                result *= x;
                nl--;
            } else {
                x *= x;
                nl /= 2;
            }
        }
        if (n < 0) result = 1 / result;
        return result;
    }
}