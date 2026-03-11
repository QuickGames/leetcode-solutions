package java_problems.medium.p1036_rotting_oranges;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("994. Rotting Oranges")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(

                Arguments.of(new int[][]{{0, 2}}, 0),

                // Ex 1: Grid with rotting process
                Arguments.of(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}, 4),
                // Ex 2: Isolated fresh orange
                Arguments.of(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}, -1),
                // Ex 3: No fresh oranges
                Arguments.of(new int[][]{{0, 2}}, 0),

                Arguments.of(new int[][]{{0}}, 0),
                Arguments.of(new int[][]{{1, 2}}, 1),
                Arguments.of(new int[][]{{2, 1, 1}, {1, 1, 1}, {0, 1, 2}}, 2)

        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int[][] grid, int expected) {
        Assertions.assertEquals(expected, new Solution().orangesRotting(grid));
    }

}