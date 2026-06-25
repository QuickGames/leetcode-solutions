int minPathSum(int** grid, int gridSize, int* gridColSize) {
    int MAX = 10000000;
    int rows = gridSize;
    int cols = gridColSize[0];
    for (int row = 0; row < rows; row++) {
        for (int col = 0; col < cols; col++) {
            if (row == 0 && col == 0) continue;

            int left = (0 <= col - 1 ? grid[row][col - 1] : MAX);
            int up = (0 <= row - 1 ? grid[row - 1][col] : MAX);
            grid[row][col] += (left < up ? left : up);
        }
    }
    return grid[rows - 1][cols - 1];
}