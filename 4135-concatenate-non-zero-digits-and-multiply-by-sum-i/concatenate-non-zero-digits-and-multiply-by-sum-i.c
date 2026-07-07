long long sumAndMultiply(int n) {
    int factor = 0;
    int result = 0;
    int rf = 1;
    while (0 < n) {
        int a = n % 10;
        n /= 10;
        if (0 < a) {
            result += a * rf;
            rf *= 10;
            factor += a;
        }
    }

    return (long long) result * factor;
}