package java_problems.hard.p0329_longest_increasing_path_in_a_matrix;

/**
 * @author QuickGames
 * Difficulty: Hard
 * Number: 329
 * Title: Longest Increasing Path in a Matrix
 * Language: Java
 * Topic: Array, Dynamic Programming, Depth-First Search, Breadth-First Search, Graph Theory, Topological Sort, Memoization, Matrix
 */
class Solution {

    private int[][] maxPath;
    private int[][] matrix;

    public int longestIncreasingPath(int[][] matrix) {

        maxPath = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) maxPath[i] = new int[matrix[i].length];
        this.matrix = matrix;

        int result = 0;
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                result = Math.max(result, getMaxPath(i, j, -1, 1));
        return result;
    }

    private int getMaxPath(int row, int col, int value, int pathLength) {
        if (pathLength < maxPath[row][col]) return 0;

        int result = 0;
        int currentValue = matrix[row][col];
        if (value < currentValue) {
            maxPath[row][col] = pathLength;
            if (col + 1 < matrix[row].length) result = Math.max(result, getMaxPath(
                    row, col + 1, currentValue, pathLength + 1));
            if (0 <= col - 1) result = Math.max(result, getMaxPath(
                    row, col - 1, currentValue, pathLength + 1));
            if (row + 1 < matrix.length) result = Math.max(result, getMaxPath(
                    row + 1, col, currentValue, pathLength + 1));
            if (0 <= row - 1) result = Math.max(result, getMaxPath(
                    row - 1, col, currentValue, pathLength + 1));
            result++;
        }
        return result;
    }

}
