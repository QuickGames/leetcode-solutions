package java_problems.medium.p1594;

/**
 * @author QuickGames
 * @Difficulty: Medium
 * @Number: 1594
 * @Title: Maximum Non-Negative Product in a Matrix
 * @Language: Java
 * @Topic: Staff, Array, Dynamic Programming, Matrix, Weekly Contest 207
 */
class Solution {

    public int maxProductPath(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        // [][][0] - max positive multi.
        // [][][1] - max negative multi.
        long[][][] gridCache = new long[rows][cols][2];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                int value = grid[row][col];
                if (row == 0 && col == 0) {
                    gridCache[row][col] = new long[]{value, value};

                } else if (row == 0) {
                    long[] lastLeftValue = gridCache[row][col - 1];
                    gridCache[row][col] = new long[]{
                            lastLeftValue[0] * value,
                            lastLeftValue[1] * value};

                } else if (col == 0) {
                    long[] lastUpValue = gridCache[row - 1][col];
                    gridCache[row][col] = new long[]{
                            lastUpValue[0] * value,
                            lastUpValue[1] * value};

                } else {
                    long[] lastUpValue = gridCache[row - 1][col];
                    long[] lastLeftValue = gridCache[row][col - 1];

                    long lastUpPositive = lastUpValue[0] * value;
                    long lastUpNegative = lastUpValue[1] * value;

                    long lastLeftPositive = lastLeftValue[0] * value;
                    long lastLeftNegative = lastLeftValue[1] * value;

                    gridCache[row][col] = new long[]{
                            Math.max(Math.max(lastUpPositive, lastUpNegative), Math.max(lastLeftPositive, lastLeftNegative)),
                            Math.min(Math.min(lastUpPositive, lastUpNegative), Math.min(lastLeftPositive, lastLeftNegative))
                    };

                }
            }
        }

        long result = gridCache[rows - 1][cols - 1][0];
        return result < 0 ? -1 : (int) (result % 1_000_000_007);
    }

}
