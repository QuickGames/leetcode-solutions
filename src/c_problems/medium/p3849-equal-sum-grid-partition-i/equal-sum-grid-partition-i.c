bool canPartitionGrid(int** grid, int gridSize, int* gridColSize) {
    
    int rows = gridSize;
    int cols = gridColSize[0];

    long long sumRows[rows];
    long long sumCols[cols];
    for (int col = 0; col < cols; col++)
        sumCols[col] = 0;

    long long allSum = 0;
    for (int row = 0; row < rows; row++) {
        sumRows[row] = 0;
        for (int col = 0; col < cols; col++) {
            sumRows[row] += grid[row][col];
            sumCols[col] += grid[row][col];
            allSum += grid[row][col];
        }
    }

    long long sum = 0;
    for (int row = 0; row < rows; row++) {
        sum += sumRows[row];
        long long remainder = allSum - sum;
        if (remainder < sum) break;
        else if (remainder == sum) return true;
    }

    sum = 0;
    for (int col = 0; col < cols; col++) {
        sum += sumCols[col];
        long long remainder = allSum - sum;
        if (remainder < sum) break;
        else if (remainder == sum) return true;
    }

    return false;
}