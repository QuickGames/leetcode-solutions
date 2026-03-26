bool findRotation(int** mat, int matSize, int* matColSize, int** target, int targetSize, int* targetColSize) {

    int rows = matSize;
    int cols = matColSize[0];

    bool is0 = true;
    bool is90 = true;
    bool is180 = true;
    bool is270 = true;
    for (int row = 0; row < rows; row++) {
        for (int col = 0; col < cols; col++) {
            if (is0) is0 = target[row][col] == mat[row][col];
            if (is90) is90 = target[row][col] == mat[cols - col - 1][row];
            if (is180) is180 = target[row][col] == mat[rows - row - 1][cols - col - 1];
            if (is270) is270 = target[row][col] == mat[col][rows - row - 1];
            if (!is0 && !is90 && !is180 && !is270) return false;
        }
    }
    
    return true;
}