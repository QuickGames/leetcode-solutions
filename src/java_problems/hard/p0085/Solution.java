package java_problems.hard.p0085;

/**
 * @author QuickGames
 * @Difficulty: Hard
 * @Number: 85
 * @Title: Maximal Rectangle
 * @Language: Java
 * @Topic: Array, Dynamic Programming, Stack, Matrix, Monotonic Stack
 */
class Solution {

    public int maximalRectangle(char[][] matrix) {
        int result = 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int row = 0; row < rows; row++) {

            // check max possible rectangle.
            if ((rows - row) * cols <= result) break;

            for (int col = 0; col < cols; col++) {

                // check max possible rectangle.
                if ((rows - row) * (cols - col) <= result) break;

                int currentSize = 0;
                if (matrix[row][col] == '1') {
                    currentSize = 1;

                    int maxCol = cols - 1;
                    for (int downRow = row; downRow < rows; downRow++) {
                        if (matrix[downRow][col] == '0') break;

                        for (int rightCol = col + 1; rightCol <= maxCol; rightCol++) {
                            if (matrix[downRow][rightCol] == '0') {
                                maxCol = rightCol - 1;
                                break;
                            }
                        }

                        // check max possible current rectangle.
                        int maxRectRows = rows - row;
                        int rectCols = maxCol - col + 1;
                        if (maxRectRows * rectCols <= result) break;

                        int thisSize = (downRow - row + 1) * rectCols;
                        currentSize = Math.max(currentSize, thisSize);

                    }

                    result = Math.max(result, currentSize);

                }

            }
        }

        return result;
    }

}
