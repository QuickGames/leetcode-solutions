package java_problems.hard.p3548;

import java_problems.SolutionTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("3548. Equal Sum Grid Partition II")
class SolutionTest extends SolutionTestBase {

    static Stream<Arguments> provideData() {
        return Stream.of(

                Arguments.of(new int[][]{{1000, 1000, 1000}, {1, 2, 4}, {2, 3, 5}, {1000, 1000, 1000}}, true),

                Arguments.of(new int[][]{{1, 4}, {2, 3}}, true),
                Arguments.of(new int[][]{{1, 2}, {3, 4}}, true),
                Arguments.of(new int[][]{{1, 2, 4}, {2, 3, 5}}, false),
                Arguments.of(new int[][]{{4, 1, 8}, {3, 2, 6}}, false),

                Arguments.of(new int[][]{{5, 5, 6, 2, 2, 2}}, true),
                Arguments.of(new int[][]{{1820, 166, 1986}}, true),
                Arguments.of(new int[][]{{253, 10, 10}}, true),
                Arguments.of(new int[][]{{10, 5, 4, 5}}, false),
                Arguments.of(new int[][]{{1,3}, {1,3}, {2,1}}, true),
                Arguments.of(new int[][]{{4,4,4}, {2,2,1}, {1,1,1}}, true)

        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int[][] grid, boolean expected) {
        Assertions.assertEquals(expected, new Solution().canPartitionGrid(grid));
    }

}