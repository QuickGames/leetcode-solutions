package java_problems.hard.p0329_longest_increasing_path_in_a_matrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.stream.Stream;

@DisplayName("329. Longest Increasing Path in a Matrix")
class SolutionTest {

    static Stream<Arguments> provideData() throws IOException {
        return Stream.of(
                // [9,9,4],[6,6,8],[2,1,1] -> path: [1, 2, 6, 9]
                Arguments.of(getRandomMatrix(), -1),
                // [9,9,4],[6,6,8],[2,1,1] -> path: [1, 2, 6, 9]
                Arguments.of(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}, 4),
                // [3,4,5],[3,2,6],[2,2,1] -> path: [3, 4, 5, 6]
                Arguments.of(new int[][]{{3, 4, 5}, {3, 2, 6}, {2, 2, 1}}, 4),
                // 1
                Arguments.of(new int[][]{{1}}, 1),
                Arguments.of(new int[][]{
                        {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                        {19, 18, 17, 16, 15, 14, 13, 12, 11, 10},
                        {20, 21, 22, 23, 24, 25, 26, 27, 28, 29},
                        {39, 38, 37, 36, 35, 34, 33, 32, 31, 30},
                        {40, 41, 42, 43, 44, 45, 46, 47, 48, 49},
                        {59, 58, 57, 56, 55, 54, 53, 52, 51, 50},
                        {60, 61, 62, 63, 64, 65, 66, 67, 68, 69},
                        {79, 78, 77, 76, 75, 74, 73, 72, 71, 70},
                        {80, 81, 82, 83, 84, 85, 86, 87, 88, 89},
                        {99, 98, 97, 96, 95, 94, 93, 92, 91, 90},
                        {100, 101, 102, 103, 104, 105, 106, 107, 108, 109},
                        {119, 118, 117, 116, 115, 114, 113, 112, 111, 110},
                        {120, 121, 122, 123, 124, 125, 126, 127, 128, 129},
                        {139, 138, 137, 136, 135, 134, 133, 132, 131, 130},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                }, 140),
                Arguments.of(parseMatrixFromFile(
                        "test/java_problems/hard/p0329/data138.csv"), 6400)
        );
    }

    private static int[][] getRandomMatrix() {
        Random random = new Random();
        int[][] matrix = new int[100][100];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(1_000_000);
            }
        }
        return matrix;
    }

    public static int[][] parseMatrixFromFile(String fileName) throws IOException {
        String content = Files.readString(Paths.get(fileName)).trim();
        content = content.substring(2, content.length() - 2);
        String[] rowStrings = content.split("\\],\\[");

        int rows = rowStrings.length;
        int cols = rowStrings[0].split(",").length;
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] elements = rowStrings[i].split(",");
            for (int j = 0; j < elements.length; j++) {
                matrix[i][j] = Integer.parseInt(elements[j].trim());
            }
        }
        return matrix;
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int[][] matrix, int expected) {
        Solution sol = new Solution();
        int actual = sol.longestIncreasingPath(matrix);
        Assertions.assertEquals(expected, actual, "Path length mismatch!");
    }

}