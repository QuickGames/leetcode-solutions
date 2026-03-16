package java_problems.medium.p1878;

import java_problems.SolutionTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("1878. Get Biggest Three Rhombus Sums in a Grid")
class SolutionTest extends SolutionTestBase {

    static Stream<Arguments> provideData() {
        return Stream.of(

                Arguments.of(
                        new int[][]{{3, 4, 5, 1, 3}, {3, 3, 4, 2, 3}, {20, 30, 200, 40, 10}, {1, 5, 5, 4, 1}, {4, 3, 2, 2, 5}},
                        new int[]{228, 216, 211}
                ),
                Arguments.of(
                        new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
                        new int[]{20, 9, 8}
                ),
                Arguments.of(
                        new int[][]{{7, 7, 7}},
                        new int[]{7}
                ),

                Arguments.of(
                        new int[][]{{20, 17, 9, 13, 5, 2, 9, 1, 5}, {14, 9, 9, 9, 16, 18, 3, 4, 12}, {18, 15, 10, 20, 19, 20, 15, 12, 11}, {19, 16, 19, 18, 8, 13, 15, 14, 11}, {4, 19, 5, 2, 19, 17, 7, 2, 2}},
                        new int[]{107, 103, 102}
                ),
                Arguments.of(
                        new int[][]{{15, 14, 15, 19, 6, 18, 15, 14}, {18, 7, 8, 10, 3, 5, 11, 19}, {20, 11, 10, 1, 6, 3, 16, 3}, {7, 14, 4, 9, 18, 14, 13, 3}, {20, 5, 15, 3, 9, 8, 16, 16}, {6, 7, 4, 12, 2, 19, 11, 20}, {20, 11, 10, 3, 4, 9, 5, 15}, {13, 10, 4, 18, 16, 2, 4, 20}},
                        new int[]{148, 130, 96}
                )

        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int[][] grid, int[] expected) {
        Assertions.assertArrayEquals(expected, new Solution().getBiggestThree(grid));
    }

}