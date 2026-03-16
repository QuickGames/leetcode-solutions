package java_problems.medium.p1878;

import java.util.Arrays;

/**
 * @author QuickGames
 * @Difficulty: Medium
 * @Number: 1878
 * @Title: Get Biggest Three Rhombus Sums in a Grid
 * @Language: Java
 * @Topic: Staff, Array, Math, Sorting, Heap (Priority Queue), Matrix, Prefix Sum, Biweekly Contest 53
 */
class Solution {

    public int[] getBiggestThree(int[][] grid) {
        int[] result = new int[4];

        int rows = grid.length;
        int cols = grid[0].length;

        int maxLength = (Math.min(rows, cols) - 1) / 2 + 1;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                for (int length = 0; length < maxLength; length++) {

                    int sum = grid[row][col];
                    if (0 < length) {
                        int upRow = row - length;
                        int downRow = row + length;
                        int leftCol = col - length;
                        int rightCol = col + length;

                        if (0 <= upRow && downRow < rows
                                && 0 <= leftCol && rightCol < cols) {
                            sum = grid[upRow][col];
                            for (int i = 1; i <= length; i++) {
                                if (upRow + i == row)
                                    sum += grid[row][leftCol] + grid[row][rightCol];
                                else {
                                    sum += grid[upRow + i][col - i] + grid[upRow + i][col + i];
                                    sum += grid[downRow - i][col - i] + grid[downRow - i][col + i];
                                }
                            }
                            sum += grid[downRow][col];
                        } else break;
                    }

                    boolean isSimilar = false;
                    for (int i = 0; i < result.length - 1; i++) {
                        if (result[i] == 0) break;
                        if (result[i] == sum) {
                            isSimilar = true;
                            break;
                        }
                    }
                    if (isSimilar) continue;
                    for (int i = result.length - 2; 0 <= i; i--) {
                        if (result[i] < sum) {
                            result[i + 1] = result[i];
                            result[i] = sum;
                        }
                    }

                }
            }
        }

        int[] r = new int[]{result[0]};
        for (int i = result.length - 2; 0 <= i; i--) {
            if (0 < result[i]) {
                r = Arrays.copyOf(result, i + 1);
                break;
            }
        }

        return r;
    }

}
