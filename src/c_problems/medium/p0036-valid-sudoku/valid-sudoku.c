bool isValidSudoku(char** board, int boardSize, int* boardColSize) {
    
    for (int row = 0; row < boardSize; row++)
        for (int col = 0; col < boardColSize[0]; col++) {
            if (board[row][col] == '.') continue;
            for (int i = 0; i < boardSize; i++)
                if (row != i && board[row][col] == board[i][col]
                    || col != i && board[row][col] == board[row][i]) return false;
            int sectorRow = row / 3 * 3;
            int sectorCol = col / 3 * 3;
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    if ((row != sectorRow + i || col != sectorCol + j)
                        && board[row][col] == board[sectorRow + i][sectorCol + j]) return false;
        }
    
    return true;
}