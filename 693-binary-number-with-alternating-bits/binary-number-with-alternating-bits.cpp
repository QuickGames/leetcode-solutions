class Solution {
public:
    bool hasAlternatingBits(int n) {
        while (2 < n) {
            if ((n & 0b11) == 3 || (n & 0b11) == 0) return false;
            n >>= 1;
        }
        return true;
    }
};