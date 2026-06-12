int uniquePaths(int m, int n) {
    int grid[m][n];
    for (int row = 0; row < m; row++) {
        for (int col = 0; col < n; col++) {
            if (row == 0 && col == 0) {
                grid[row][col] = 1;
                continue;
            }
            int sum = 0;
            if (0 < row) sum += grid[row - 1][col];
            if (0 < col) sum += grid[row][col - 1];
            grid[row][col] = sum;
        }
    }
    return grid[m - 1][n - 1];
}