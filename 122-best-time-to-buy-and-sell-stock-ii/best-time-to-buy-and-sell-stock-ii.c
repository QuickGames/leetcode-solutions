int maxProfit(int* prices, int pricesSize) {
    int result = 0;
    int b = prices[0];
    int s = b;
    int last = b;
    for (int i = 1; i < pricesSize; i++) {
        int n = prices[i];
        if (last < n) s = n;
        else {
            result += s - b;
            b = n;
            s = n;
        }
        last = n;
    }
    result += s - b;
    return result;
}