public class Solution {

    public int[][] OnesMinusZeros(int[][] grid) {

        int[] rows = new int[grid.Length];
        for (int i = 0; i < grid.Length; i++) {
            for (int j = 0; j < grid[i].Length; j++) {
                if (grid[i][j] == 1) rows[i]++;
                else rows[i]--;
            }
        }
        int[] cols = new int[grid[0].Length];
        for (int j = 0; j < grid[0].Length; j++) {
            for (int i = 0; i < grid.Length; i++) {
                if (grid[i][j] == 1) cols[j]++;
                else cols[j]--;
            }
        }

        int[][] result = new int[grid.Length][];
        for (int i = 0; i < grid.Length; i++) {
            result[i] = new int[grid[i].Length];
            for (int j = 0; j < grid[i].Length; j++) {
                result[i][j] = rows[i] + cols[j];
            }
        }
        return result;
    }
    
}