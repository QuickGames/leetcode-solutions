bool areSimilar(int** mat, int matSize, int* matColSize, int k) {
    
    int add = k % matColSize[0];
    if (add == 0) return true;

    for (int row = 0; row < matSize; row++)
        for (int col = 0; col < matColSize[row]; col++)
            if (mat[row][col] != mat[row][(col + add) % matColSize[row]]) return false;

    return true;
}