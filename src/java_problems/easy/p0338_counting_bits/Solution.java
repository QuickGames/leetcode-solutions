package java_problems.easy.p0338_counting_bits;

class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        for (int i = 0; i <= n; i++){
            int c = i;
            while (0 < c) {
                if ((c & 1) == 1) result[i]++;
                c >>= 1;
            }
        }
        return result;
    }
}