package java_problems.medium.p1658_minimum_swaps_to_arrange_a_binary_grid;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("1536. Minimum Swaps to Arrange a Binary Grid")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                // Example 1: [[0,0,1],[1,1,0],[1,0,0]] -> 3
                Arguments.of(new int[][]{{0, 0, 1}, {1, 1, 0}, {1, 0, 0}}, 3),
                // Example 2: [[0,1,1,0],[0,1,1,0],[0,1,1,0],[0,1,1,0]] -> -1
                Arguments.of(new int[][]{{0, 1, 1, 0}, {0, 1, 1, 0}, {0, 1, 1, 0}, {0, 1, 1, 0}}, -1),
                // Example 3: [[1,0,0],[1,1,0],[1,1,1]] -> 0
                Arguments.of(new int[][]{{1, 0, 0}, {1, 1, 0}, {1, 1, 1}}, 0),
                Arguments.of(new int[][]{
                        {1, 0, 0, 0},
                        {1, 1, 1, 1},
                        {1, 0, 0, 0},
                        {1, 0, 0, 0}}, 2),
                Arguments.of(new int[][]{
                        {1, 0, 0, 0},
                        {1, 0, 0, 0},
                        {1, 1, 0, 0},
                        {0, 1, 0, 0}}, 0),
                Arguments.of(new int[][]{
                        {1, 0, 0, 0, 0, 0},
                        {0, 1, 0, 1, 0, 0},
                        {1, 0, 0, 0, 0, 0},
                        {1, 1, 1, 0, 0, 0},
                        {1, 1, 0, 1, 0, 0},
                        {1, 0, 0, 0, 0, 0}}, 2),
                Arguments.of(new int[][]{
                        {1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 1, 0},
                        {0, 0, 1, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1}}, 5),
                Arguments.of(new int[][]{
                        {0, 0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 1, 0, 0},
                        {0, 0, 1, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0, 0}
                }, 15),
                Arguments.of(new int[][]{
                        {0, 1, 1, 0},
                        {1, 1, 1, 0},
                        {1, 1, 1, 0},
                        {1, 0, 0, 0}
                }, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int[][] grid, int expected) {
        Solution sol = new Solution();
        int actual = sol.minSwaps(grid);
        Assertions.assertEquals(expected, actual, "Swap count mismatch!");
    }

}