void setZeroes(int** matrix, int matrixSize, int* matrixColSize) {

    bool zeroRows[matrixSize];
    for (int row = 0; row < matrixSize; row++)
        zeroRows[row] = false;
    bool zeroCols[matrixColSize[0]];
    for (int col = 0; col < matrixColSize[0]; col++)
        zeroCols[col] = false;
    
    bool isReplace = false;
    for (int row = 0; row < matrixSize; row++)
        for (int col = 0; col < matrixColSize[row]; col++)
            if (matrix[row][col] == 0) {
                isReplace = true;
                zeroRows[row] = true;
                zeroCols[col] = true;
            }
    
    if (isReplace) {
        for (int row = 0; row < matrixSize; row++)
            if (zeroRows[row])
                for (int col = 0; col < matrixColSize[0]; col++)
                    matrix[row][col] = 0;
        for (int col = 0; col < matrixColSize[0]; col++)
            if (zeroCols[col])
                for (int row = 0; row < matrixSize; row++)
                    matrix[row][col] = 0;
    }

}