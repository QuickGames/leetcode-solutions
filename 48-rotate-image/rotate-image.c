void rotate(int** matrix, int matrixSize, int* matrixColSize) {
    
    int size = matrixSize;
    int size1 = size - 1;
    int size2 = size1 / 2 + 1;

    int rows2 = size / 2;

    for (int row = 0; row < rows2; row++) {
        for (int col = 0; col < size2; col++) {
            int buf = matrix[row][col];
            matrix[row][col] = matrix[size1 - col][row];
            matrix[size1 - col][row] = matrix[size1 - row][size1 - col];
            matrix[size1 - row][size1 - col] = matrix[col][size1 - row];
            matrix[col][size1 - row] = buf;
        }
    }

}