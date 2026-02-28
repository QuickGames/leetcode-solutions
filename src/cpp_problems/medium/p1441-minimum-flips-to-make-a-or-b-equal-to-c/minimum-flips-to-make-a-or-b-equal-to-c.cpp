class Solution {
public:
    int minFlips(int a, int b, int c) {
        int result = 0;
        while (a != 0 || b != 0 || c != 0) {
            int ab = a & 1;
            int bb = b & 1;
            int cb = c & 1;
            if (cb != (ab | bb)) {
                if (cb == 1) result++;
                else {
                    if (ab == 1) result++;
                    if (bb == 1) result++;
                }
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return result;
    }
};