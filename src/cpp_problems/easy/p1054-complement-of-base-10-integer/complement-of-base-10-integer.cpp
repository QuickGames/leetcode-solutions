class Solution {
public:
    int bitwiseComplement(int n) {
        if (n == 0) return 1;
        int result = 0;
        int add = 1;
        while (0 < n) {
            if ((n & 1) == 0) result |= add;
            n >>= 1;
            add <<= 1;
        }
        return result;
    }
};