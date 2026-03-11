package java_problems.medium.p1036_rotting_oranges;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 994
 * Title: Rotting Oranges
 * Language: Java
 * Topic: Staff, Array, Breadth-First Search, Matrix, Weekly Contest 124
 */
class Solution {

    public int orangesRotting(int[][] grid) {
        int result = 0;

        ArrayInt2 rotted = new ArrayInt2();
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) result = -1;
                else if (grid[i][j] == 2) rotted.add(i, j);
            }

        if (result == 0) return result;

        ArrayInt2 nextRotted = new ArrayInt2();

        while (0 < rotted.getLength()) {

            for (int i = 0; i < rotted.getLength(); i++) {
                int[] food = rotted.get(i);

                int row = food[0];
                int col = food[1];

                int nextRow = row;
                int nextCol = col;

                nextCol = col - 1;
                if (0 <= nextCol && grid[nextRow][nextCol] == 1) {
                    grid[nextRow][nextCol] = 2;
                    nextRotted.add(nextRow, nextCol);
                }

                nextCol = col + 1;
                if (nextCol < grid[row].length && grid[nextRow][nextCol] == 1) {
                    grid[nextRow][nextCol] = 2;
                    nextRotted.add(nextRow, nextCol);
                }

                nextRow = row - 1;
                nextCol = col;
                if (0 <= nextRow && grid[nextRow][nextCol] == 1) {
                    grid[nextRow][nextCol] = 2;
                    nextRotted.add(nextRow, nextCol);
                }

                nextRow = row + 1;
                if (nextRow < grid.length && grid[nextRow][nextCol] == 1) {
                    grid[nextRow][nextCol] = 2;
                    nextRotted.add(nextRow, nextCol);
                }

            }

            rotted.fill(nextRotted);
            nextRotted.clear();
            result++;
        }

        for (int[] ints : grid)
            for (int anInt : ints)
                if (anInt == 1) return -1;

        return result;
    }

    private static class ArrayInt2 {

        private final int[][] nums = new int[100][2];
        private int length = 0;

        public int getLength() {
            return length;
        }

        int[] get(int index) {
            return new int[]{nums[index][0], nums[index][1]};
        }

        void add(int row, int col) {
            nums[length] = new int[]{row, col};
            length++;
        }

        void fill(ArrayInt2 values) {
            clear();
            for (int i = 0; i < values.length; i++)
                add(values.nums[i][0], values.nums[i][1]);
        }

        void clear() {
            length = 0;
        }

    }

}
