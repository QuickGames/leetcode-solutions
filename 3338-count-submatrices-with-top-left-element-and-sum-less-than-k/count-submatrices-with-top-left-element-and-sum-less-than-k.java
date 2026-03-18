class Solution {

    public int countSubmatrices(int[][] grid, int k) {
        int result = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        int currentRow = 0;
        int currentCol = cols - 1;

        int rectS = 0;
        for (int i = 0; i < grid[currentRow].length; i++) {
            int nextRectS = rectS + grid[currentRow][i];
            if (k < nextRectS) {
                currentCol = i - 1;
                break;
            } else {
                result++;
                rectS = nextRectS;
            }
        }

        while (0 <= currentCol) {

            currentRow++;
            if (rows <= currentRow) break;

            for (int i = 0; i <= currentCol; i++)
                rectS += grid[currentRow][i];

            while (k < rectS) {
                for (int row = 0; row <= currentRow; row++)
                    rectS -= grid[row][currentCol];
                currentCol--;
            }

            result += currentCol + 1;

        }

        return result;
    }

}