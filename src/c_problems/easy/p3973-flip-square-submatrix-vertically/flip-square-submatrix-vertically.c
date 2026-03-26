/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
int** reverseSubmatrix(int** grid, int gridSize, int* gridColSize, int x, int y, int k, int* returnSize, int** returnColumnSizes) {
    
    returnSize[0] = gridSize;
    returnColumnSizes[0] = gridColSize;

    int** result = malloc(gridSize * sizeof(int*));
    for (int row = 0; row < gridSize; row++) {
        result[row] = malloc(gridColSize[row] * sizeof(int));
        for (int col = 0; col < gridColSize[row]; col++)
            if (x <= row && row < x + k && y <= col && col < y + k)
                result[row][col] = grid[x + k - 1 - (row - x)][col];
            else result[row][col] = grid[row][col];
    }

    return result;
}