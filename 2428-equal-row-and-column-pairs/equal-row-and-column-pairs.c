int equalPairs(int** grid, int gridSize, int* gridColSize) {
    int result = 0;

    for (int i = 0; i < gridSize; i++) {
        for (int j = 0; j < gridSize; j++) {
            bool isEquals = true;
            for (int k = 0; k < gridSize; k++) {
                if (grid[i][k] != grid[k][j]) {
                    isEquals = false;
                    break;
                }
            }
            if (isEquals) result++;
        }
    }

    return result;
}