package java_problems.hard.p3548;

/**
 * @author QuickGames
 * @Difficulty: Hard
 * @Number: 3548
 * @Title: Equal Sum Grid Partition II
 * @Language: Java
 * @Topic: Principal, Array, Hash Table, Matrix, Enumeration, Prefix Sum, Weekly Contest 449
 */
class Solution {

    public boolean canPartitionGrid(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int[] sourceFrequencyRows = new int[100_001];
        int[] sourceFrequencyCols = new int[100_001];
        long sourceSum = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                sourceFrequencyRows[grid[row][col]]++;
                sourceFrequencyCols[grid[row][col]]++;
                sourceSum += grid[row][col];
            }
        }

        if (1 < rows) {
            int[] rFrequency = new int[100_001];
            long rSum = 0;
            for (int row = 0; row < rows - 1; row++) {
                for (int col = 0; col < cols; col++) {
                    rSum += grid[row][col];
                    rFrequency[grid[row][col]]++;
                    sourceFrequencyRows[grid[row][col]]--;
                }
                long remainder = sourceSum - rSum;
                if (rSum == remainder) return true;
                if (rows < 3 || cols == 1) {
                    if (rSum - grid[0][0] == remainder
                            || rSum - grid[row][0] == remainder
                            || rSum == remainder - grid[row + 1][0]
                            || rSum == remainder - grid[rows - 1][0])
                        return true;
                } else {
                    long hsr = rSum - remainder;
                    if (0 < row && 0 < hsr && hsr < 100_001) {
                        if (0 < rFrequency[(int) hsr]) return true;
                    } else {
                        if (rSum - grid[0][0] == remainder
                                || rSum - grid[0][cols - 1] == remainder)
                            return true;
                    }
                    long rhs = remainder - rSum;
                    if (row < rows - 2 && 0 < rhs && rhs < 100_001) {
                        if (0 < sourceFrequencyRows[(int) rhs]) return true;
                    } else {
                        if (rSum - grid[rows - 1][0] == remainder
                                || rSum - grid[rows - 1][cols - 1] == remainder)
                            return true;
                    }
                }
            }
        }

        if (1 < cols) {
            int[] cFrequency = new int[100_001];
            long cSum = 0;
            for (int col = 0; col < cols - 1; col++) {
                for (int row = 0; row < rows; row++) {
                    cSum += grid[row][col];
                    cFrequency[grid[row][col]]++;
                    sourceFrequencyCols[grid[row][col]]--;
                }
                long remainder = sourceSum - cSum;
                if (cSum == remainder) return true;
                if (cols < 3 || rows == 1) {
                    if (cSum - grid[0][0] == remainder
                            || cSum - grid[0][col] == remainder
                            || cSum == remainder - grid[0][col + 1]
                            || cSum == remainder - grid[0][cols - 1])
                        return true;
                } else {
                    long hsr = cSum - remainder;
                    if (0 < col && 0 < hsr && hsr < 100_001) {
                        if (0 < cFrequency[(int) hsr]) return true;
                    } else {
                        if (cSum - grid[0][0] == remainder
                                || cSum - grid[rows - 1][0] == remainder)
                            return true;
                    }
                    long rhs = remainder - cSum;
                    if (col < cols - 2 && 0 < rhs && rhs < 100_001) {
                        if (0 < sourceFrequencyCols[(int) rhs]) return true;
                    } else {
                        if (cSum - grid[0][cols - 1] == remainder
                                || cSum - grid[rows - 1][cols - 1] == remainder)
                            return true;
                    }
                }
            }
        }

        return false;
    }

}
