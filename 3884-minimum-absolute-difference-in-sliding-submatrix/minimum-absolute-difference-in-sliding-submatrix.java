class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {

        int rows = grid.length;
        int cols = grid[0].length;

        int resultRows = rows - k + 1;
        int resultCols = cols - k + 1;
        int[][] result = new int[resultRows][resultCols];

        for (int resultRow = 0; resultRow < resultRows; resultRow++) {
            for (int resultCol = 0; resultCol < resultCols; resultCol++) {
                int[] nums = new int[k * k];
                for (int row = 0; row < k; row++)
                    for (int col = 0; col < k; col++)
                        nums[row * k + col] = grid[resultRow + row][resultCol + col];
                Arrays.sort(nums);
                int resultValue = Integer.MAX_VALUE;
                for (int i = 0; i < nums.length - 1; i++) {
                    int value = nums[i + 1] - nums[i];
                    if (value == 1) {
                        resultValue = 1;
                        break;
                    } else if (1 < value)
                        resultValue = Math.min(resultValue, value);
                }
                if (resultValue == Integer.MAX_VALUE) resultValue = 0;

                result[resultRow][resultCol] = resultValue;
            }
        }

        return result;
    }
}