package java_problems.hard.p0042_trapping_rain_water;

/**
 * @author QuickGames
 * Difficulty: Hard
 * Number: 42
 * Title: Trapping Rain Water
 * Language: Java
 * Topic: Array, Two Pointers, Dynamic Programming, Stack, Monotonic Stack
 */
class Solution {

    public int trap(int[] height) {
        int result = 0;

        int[][] cache = new int[height.length][2];
        cache[0] = new int[]{height[0], 0}; // height, index
        int cacheLength = 1;

        int lastHeight = height[0];
        for (int i = 1; i < height.length; i++) {
            int current = height[i];
            if (0 < current) {
                while (0 < cacheLength && cache[cacheLength - 1][0] <= current) {
                    int length = i - cache[cacheLength - 1][1] - 1;
                    if (0 < length) {
                        int difHeight = cache[cacheLength - 1][0] - lastHeight;
                        result += length * difHeight;
                    }
                    lastHeight = cache[cacheLength - 1][0];
                    cacheLength--;
                }
                if (0 < cacheLength) {
                    int difHeight = current - lastHeight;
                    if (0 < difHeight) {
                        int length = i - cache[cacheLength - 1][1] - 1;
                        if (0 < length) result += length * difHeight;
                    }
                }
                cache[cacheLength] = new int[]{current, i};
                cacheLength++;
            }
            lastHeight = current;
        }

        return result;
    }

}
