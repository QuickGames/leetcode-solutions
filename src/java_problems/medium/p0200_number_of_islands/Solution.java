package java_problems.medium.p0200_number_of_islands;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 200
 * Title: Number of Islands
 * Language: Java
 * Topic: Array, Depth-First Search, Breadth-First Search, Union-Find, Matrix
 */
class Solution {

    public int numIslands(char[][] grid) {
        int[][] steps = new int[grid.length * grid[0].length][2];
        int result = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                if (grid[i][j] == '1') {

                    steps[0] = new int[]{i, j};
                    grid[i][j] = '2';
                    int currentStep = 0;
                    int stepsCount = 1;

                    while (currentStep < stepsCount) {
                        int[] step = steps[currentStep];
                        int row = step[0];
                        int col = step[1];

                        int nextRow = row - 1;
                        int nextCol = col;
                        if (0 <= nextRow && grid[nextRow][nextCol] == '1') {
                            grid[nextRow][nextCol] = '2';
                            steps[stepsCount] = new int[]{nextRow, nextCol};
                            stepsCount++;
                        }
                        nextRow = row + 1;
                        if (nextRow < grid.length && grid[nextRow][nextCol] == '1') {
                            grid[nextRow][nextCol] = '2';
                            steps[stepsCount] = new int[]{nextRow, nextCol};
                            stepsCount++;
                        }
                        nextRow = row;
                        nextCol = col - 1;
                        if (0 <= nextCol && grid[nextRow][nextCol] == '1') {
                            grid[nextRow][nextCol] = '2';
                            steps[stepsCount] = new int[]{nextRow, nextCol};
                            stepsCount++;
                        }
                        nextCol = col + 1;
                        if (nextCol < grid[nextRow].length && grid[nextRow][nextCol] == '1') {
                            grid[nextRow][nextCol] = '2';
                            steps[stepsCount] = new int[]{nextRow, nextCol};
                            stepsCount++;
                        }

                        currentStep++;
                    }

                    result++;
                }
        return result;
    }

}
