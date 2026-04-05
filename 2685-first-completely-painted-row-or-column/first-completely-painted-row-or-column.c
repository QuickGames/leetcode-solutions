int firstCompleteIndex(int* arr, int arrSize, int** mat, int matSize, int* matColSize) {
    
    int rows = matSize;
    int cols = matColSize[0];

    int nums[arrSize + 1][2];

    for (int row = 0; row < rows; row++) {
        for (int col = 0; col < cols; col++) {
            int index = mat[row][col];
            nums[index][0] = row;
            nums[index][1] = col;
        }
    }

    int bRows[rows];
    for (int i = 0; i < rows; i++) bRows[i] = 0;
    int bCols[cols];
    for (int i = 0; i < cols; i++) bCols[i] = 0;

    int result = 0;
    for (int i = 0; i < arrSize; i++) {
        int* pos = nums[arr[i]];
        bRows[pos[0]]++;
        if (bRows[pos[0]] == cols) break;
        bCols[pos[1]]++;
        if (bCols[pos[1]] == rows) break;
        result++;
    }

    return result;
}