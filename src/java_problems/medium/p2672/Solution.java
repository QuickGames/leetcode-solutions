package java_problems.medium.p2672;

/**
 * @author QuickGames
 * @Difficulty: Medium
 * @Number: 2672
 * @Title: Number of Adjacent Elements With the Same Color
 * @Language: Java
 * @Topic: Staff, Array, Weekly Contest 344
 */
class Solution {

    public int[] colorTheArray(int n, int[][] queries) {
        if (queries.length == 1) return new int[]{0};

        int[] colors = new int[n];

        int[] result = new int[queries.length];
        int lastCount = 0;
        for (int i = 0; i < queries.length; i++) {
            int count = lastCount;

            int[] query = queries[i];
            int qIndex = query[0];
            int qColor = query[1];
            if (colors[qIndex] != 0) {
                if (0 < qIndex && colors[qIndex - 1] == colors[qIndex]) count--;
                if (qIndex + 1 < n && colors[qIndex] == colors[qIndex + 1]) count--;
            }

            if (0 < qIndex && colors[qIndex - 1] == qColor) count++;
            if (qIndex + 1 < n && qColor == colors[qIndex + 1]) count++;

            colors[qIndex] = qColor;

            lastCount = count;
            result[i] = count;
        }
        return result;
    }

}
