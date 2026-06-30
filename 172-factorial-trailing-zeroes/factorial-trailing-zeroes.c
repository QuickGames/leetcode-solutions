int trailingZeroes(int n) {
    int result = 0;
    int a = 5;
    while (a <= n) {
        result += n / a;
        a *= 5;
    }
    return result;
}