class Solution {
public:
    bool isPowerOfFour(int n) {
        if (n < 1) return false;
        if (n == 1) return true;
        int k = n >> 2;
        return k << 2 == n ? isPowerOfFour(k) : false;
    }
};