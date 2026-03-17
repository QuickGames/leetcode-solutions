package java_problems.hard.p0085;

import java_problems.SolutionTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("85. Maximal Rectangle")
class SolutionTest extends SolutionTestBase {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}, 4),
                Arguments.of(new char[][]{{'0'}}, 0),
                Arguments.of(new char[][]{{'1'}}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(char[][] matrix, int expected) {
        Assertions.assertEquals(expected, new Solution().maximalRectangle(matrix));
    }

}