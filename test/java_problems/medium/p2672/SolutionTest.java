package java_problems.medium.p2672;

import java_problems.SolutionTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("2672. Number of Adjacent Elements With the Same Color")
class SolutionTest extends SolutionTestBase {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(4, new int[][]{{0, 2}, {1, 2}, {3, 1}, {1, 1}, {2, 1}}, new int[]{0, 1, 1, 0, 2}),
                Arguments.of(1, new int[][]{{0, 100000}}, new int[]{0})
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int n, int[][] queries, int[] expected) {
        Assertions.assertArrayEquals(expected, new Solution().colorTheArray(n, queries));
    }

}