/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* spiralOrder(int** matrix, int matrixSize, int* matrixColSize, int* returnSize) {

    int rows = matrixSize;
    int cols = *matrixColSize;

    *returnSize = rows * cols;
    int* result = (int*)malloc((*returnSize) * sizeof(int));

    int minRow = 0;
    int maxRow = rows - 1;
    int minCol = 0;
    int maxCol = cols - 1;

    int row = 0;
    int col = 0;

    // 0 - right.
    // 1 - down.
    // 2 - left.
    // 3 - up.
    int direction = 0;
    if (minCol == maxCol) direction = 1;

    result[0] = matrix[0][0];
    for (int i = 1; i < *returnSize; i++) {
        if (direction == 0) {
            col++;
            if (col == maxCol) {
                minRow++;
                direction = 1;
            }
        } else if (direction == 1) {
            row++;
            if (row == maxRow) {
                maxCol--;
                direction = 2;
            }
        } else if (direction == 2) {
            col--;
            if (col == minCol) {
                maxRow--;
                direction = 3;
            }
        } else if (direction == 3) {
            row--;
            if (row == minRow) {
                minCol++;
                direction = 0;
            }
        }
        printf("%dx%d\n", row, col);
        result[i] = matrix[row][col];
    }
    
    return result;
}