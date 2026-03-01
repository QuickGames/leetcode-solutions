class StockSpanner {

    private final int[] prices;
    private int length;

    public StockSpanner() {
        prices = new int[10000];
        length = 0;
    }

    public int next(int price) {

        int result = 1;
        for (int i = length - 1; 0 <= i; i--)
            if (prices[i] <= price) result++;
            else break;

        prices[length] = price;
        length++;
        return result;
    }

}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */