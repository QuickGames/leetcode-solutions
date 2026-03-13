package java_problems.easy.p0121;

/**
 * @author QuickGames
 * Difficulty: Easy
 * Number: 121
 * Title: Best Time to Buy and Sell Stock
 * Language: Java
 * Topic: Array, Dynamic Programming
 */
class Solution {

    public int maxProfit(int[] prices) {
        int result = 0;
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            if (price < minPrice) minPrice = price;
            else result = Math.max(result, price - minPrice);
        }

        return result;
    }
}
