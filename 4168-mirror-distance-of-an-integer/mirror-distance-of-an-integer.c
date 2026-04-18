int mirrorDistance(int n) {

    int k = n;
    int r = 0;
    while (0 < k) {
        r *= 10;
        r += k % 10;
        k /= 10;
    }

    return abs(r - n);
}