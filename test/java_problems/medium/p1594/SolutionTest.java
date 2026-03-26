package java_problems.medium.p1594;

import java_problems.SolutionTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("1594. Maximum Non Negative Product in a Matrix")
class SolutionTest extends SolutionTestBase {

    static Stream<Arguments> provideData() {
        return Stream.of(

                Arguments.of(new int[][]{{-1, -2, -3}, {-2, -3, -3}, {-3, -3, -2}}, -1),
                Arguments.of(new int[][]{{1, -2, 1}, {1, -2, 1}, {3, -4, 1}}, 8),
                Arguments.of(new int[][]{{1, 3}, {0, -4}}, 0),

                Arguments.of(new int[][]{
                        {2, 1, 3, 0, -3, 3, -4, 4, 0, -4},
                        {-4, -3, 2, 2, 3, -3, 1, -1, 1, -2},
                        {-2, 0, -4, 2, 4, -3, -4, -1, 3, 4},
                        {-1, 0, 1, 0, -3, 3, -2, -3, 1, 0},
                        {0, -1, -2, 0, -3, -4, 0, 3, -2, -2},
                        {-4, -2, 0, -1, 0, -3, 0, 4, 0, -3},
                        {-3, -4, 2, 1, 0, -4, 2, -4, -1, -3},
                        {3, -2, 0, -4, 1, 0, 1, -3, -1, -1},
                        {3, -4, 0, 2, 0, -2, 2, -4, -2, 4},
                        {0, 4, 0, -3, -4, 3, 3, -1, -2, -2}
                }, 19215865)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int[][] grid, int expected) {
        Assertions.assertEquals(expected, new Solution().maxProductPath(grid));
    }

}