class Solution {
    
    public int largestSubmatrix(int[][] matrix) {

        int[][] counts = new int[matrix.length][matrix[0].length];

        for (int col = 0; col < matrix[0].length; col++) {
            int count = 0;
            for (int row = matrix.length - 1; row >= 0; row--) {
                if (matrix[row][col] == 1) count++;
                else count = 0;
                counts[row][col] = count;
            }
        }

        int result = 0;
        for (int j = 0; j < counts.length; j++) {

            int maxAllowedSize = (counts.length - j) * counts[0].length;
            if (maxAllowedSize <= result) break;

            int[] count = counts[j];
            int[] stats = new int[matrix.length + 1];
            for (int i : count) stats[i]++;
            int allCount = 0;
            for (int i = stats.length - 1; 0 < i; i--) {

                int maxAllowed = i * counts[0].length;
                if (maxAllowed <= result) break;

                stats[i] += allCount;
                allCount = stats[i];
                result = Math.max(result, stats[i] * i);
            }
        }

        return result;
    }

}