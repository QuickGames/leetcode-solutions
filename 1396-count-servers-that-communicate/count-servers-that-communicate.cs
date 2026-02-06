public class Solution {
    public int CountServers(int[][] grid) {
        int result = 0;
        for(int i = 0; i < grid.Length; i++) {
            for(int j = 0; j < grid[i].Length; j++) {
                if (grid[i][j] == 1) {
                    result += checkConnect(grid, i, j);
                }
            }
        }
        return result;
    }

    private int checkConnect(int[][] grid, int indexI, int indexJ) {
        int count = 0;

        for(int i = 0; i < grid[indexI].Length; i++) {
            count += grid[indexI][i];
            if (1 < count) return 1;
        }
        count = 0;
        for(int i = 0; i < grid.Length; i++) {
            count += grid[i][indexJ];
            if (1 < count) return 1;
        }
        
        return 0;
    }

}