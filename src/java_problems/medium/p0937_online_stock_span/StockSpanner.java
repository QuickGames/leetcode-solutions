package java_problems.medium.p0937_online_stock_span;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 901
 * Title: Online Stock Span
 * Language: Java
 * Topic: Senior, Stack, Design, Monotonic Stack, Data Stream, Weekly Contest 101
 */
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
//  {null, 1, 1, 3, 4, 5, 6, 7, 8, 9, 10}

}
