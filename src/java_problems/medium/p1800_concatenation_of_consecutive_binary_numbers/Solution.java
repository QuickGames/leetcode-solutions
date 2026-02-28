package java_problems.medium.p1800_concatenation_of_consecutive_binary_numbers;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 1680
 * Title: Concatenation of Consecutive Binary Numbers
 * Language: Java
 * Topic: Staff, Math, Bit Manipulation, Simulation, Weekly Contest 218
 */
class Solution {

    private static final int BITS_LENGTH = 32;
    private static final int MODULO = 1_000_000_007;

    public int concatenatedBinary(int n) {
        long result = 0;

        boolean[] bits = new boolean[BITS_LENGTH];
        for (int i = 1; i <= n; i++) {

            int k = i;
            int length = 0;
            while (0 < k) {
                bits[BITS_LENGTH - length - 1] = ((k & 1) == 1);
                k >>= 1;
                length++;
            }

            int bitsStart = BITS_LENGTH - length ;
            for (int j = 0; j < length; j++) {
                result <<= 1;
                if (bits[bitsStart + j]) result |= 1;
            }
            if (MODULO < result) result %= MODULO;

        }

        return (int) result;
    }

}
