package java_problems.medium.p3070;

import java_problems.SolutionTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("3070. Count Submatrices with Top-Left Element and Sum Less Than k")
class SolutionTest extends SolutionTestBase {

    static Stream<Arguments> provideData() {
        return Stream.of(

                Arguments.of(new int[][]{{3, 10, 5}, {6, 3, 1}}, 10, 1),

//                Arguments.of(new int[][]{{7, 6, 3}, {6, 6, 1}}, 18, 4),
//                Arguments.of(new int[][]{{7, 2, 9}, {1, 5, 0}, {2, 6, 6}}, 20, 6),

                Arguments.of(new int[][]{{3, 10, 5}, {6, 3, 1}}, 4, 1)

        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int[][] grid, int k, int expected) {
        Assertions.assertEquals(expected, new Solution().countSubmatrices(grid, k));
    }

}