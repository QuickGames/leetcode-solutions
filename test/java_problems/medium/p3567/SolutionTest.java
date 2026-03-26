package java_problems.medium.p3567;

import java_problems.SolutionTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("3567. Minimum Absolute Difference in Sliding Submatrix")
class SolutionTest extends SolutionTestBase {

    static Stream<Arguments> provideData() {
        return Stream.of(

                Arguments.of(new int[][]{{1, 8}, {3, -2}}, 2, new int[][]{{2}}),
                Arguments.of(new int[][]{{3, -1}}, 1, new int[][]{{0, 0}}),
                Arguments.of(new int[][]{{1, -2, 3}, {2, 3, 5}}, 2, new int[][]{{1, 2}}),

                Arguments.of(new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                }, 5, new int[][]{
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0}
                })
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest2(int[][] grid, int k, int[][] expected) {
        Assertions.assertArrayEquals(expected, new Solution().minAbsDiff(grid, k));
    }

}