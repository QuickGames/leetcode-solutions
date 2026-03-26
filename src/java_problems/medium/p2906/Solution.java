package java_problems.medium.p2906;

/**
 * @author QuickGames
 * @Difficulty: Medium
 * @Number: 2906
 * @Title: Construct Product Matrix
 * @Language: Java
 * @Topic: Staff, Array, Matrix, Prefix Sum, Weekly Contest 367
 */
class Solution {

    public int[][] constructProductMatrix(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] result = new int[rows][cols];

        long[][] accR = new long[rows][cols];
        long[][] accL = new long[rows][cols];

        for (int row = 0; row < rows; row++) {
            accR[row][0] = 1;
            for (int col = 1; col < cols; col++)
                accR[row][col] = (accR[row][col - 1] * grid[row][col - 1]) % 12345;
        }

        for (int row = 0; row < rows; row++) {
            accL[row][cols - 1] = 1;
            for (int col = cols - 2; 0 <= col; col--)
                accL[row][col] = (accL[row][col + 1] * grid[row][col + 1]) % 12345;
        }


        long[] accRowsD = new long[rows];
        long[] accRowsU = new long[rows];

        accRowsD[0] = 1;
        for (int row = 1; row < accRowsD.length; row++)
            accRowsD[row] = ((accL[row - 1][0] * grid[row - 1][0] * accRowsD[row - 1]) % 12345);

        accRowsU[rows - 1] = 1;
        for (int row = accRowsU.length - 2; 0 <= row; row--)
            accRowsU[row] =  ((accL[row + 1][0] * grid[row + 1][0] * accRowsU[row + 1]) % 12345);


        for (int row = 0; row < rows; row++)
            for (int col = 0; col < cols; col++)
                result[row][col] = (int) ((accR[row][col] * accL[row][col] * accRowsD[row] * accRowsU[row]) % 12345);

        return result;
    }

}
