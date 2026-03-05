package java_problems.medium.p0803_cheapest_flights_within_k_stops;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 787
 * Title: Cheapest Flights Within K Stops
 * Language: Java
 * Topic: Principal, Dynamic Programming, Depth-First Search, Breadth-First Search, Graph Theory, Heap (Priority Queue), Shortest Path, Weekly Contest 72
 */
class Solution {

    private int[][] flights;    // [from, to, price]
    private int dst;
    private int k;

    private int minPrice;
    private int minOut = Integer.MAX_VALUE;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        this.flights = flights;
        this.dst = dst;
        this.k = k;

        this.minPrice = Integer.MAX_VALUE;

        boolean isStart = false;
        boolean isFinish = false;
        for (int[] flight : flights) {
            if (flight[0] == src) isStart = true;
            if (flight[1] == dst) isFinish = true;
        }
        if (!isStart || !isFinish) return -1;

        findPath(src, 0, 0);
        return (this.minPrice == Integer.MAX_VALUE ? -1 : this.minPrice);
    }

    private void findPath(int from, int price, int stops) {
        if (this.k < stops) return;
        if (this.minPrice < price) return;

        for (int[] flight : flights) {
            if (from == flight[0]) {
                int path = Integer.MAX_VALUE;
                if (dst == flight[1]) {
                    path = price + flight[2];
                } else {
                    int curPrice = price + flight[2];
                    findPath(flight[1], curPrice, stops + 1);
                    if (this.minPrice < minOut) {
                        minOut = minPrice;
                        System.out.println("path: " + minPrice);
                    }
                }
                this.minPrice = Math.min(this.minPrice, path);
            }
        }

    }

}
