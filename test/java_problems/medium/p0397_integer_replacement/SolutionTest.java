package java_problems.medium.p0397_integer_replacement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("397. Integer Replacement")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(1, 0),
                Arguments.of(2, 1),
                Arguments.of(2147483647, 32),

                // 8 -> 4 -> 2 -> 1 (3 steps)
                Arguments.of(8, 3),
                // 7 -> 8 -> 4 -> 2 -> 1 (4 steps)
                Arguments.of(7, 4),
                // 4 -> 2 -> 1 (2 steps)
                Arguments.of(4, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int n, int expected) {
        Solution sol = new Solution();
        int actual = sol.integerReplacement(n);
        Assertions.assertEquals(expected, actual,
                String.format("Failed for n=%d! Expected %d steps, but got %d", n, expected, actual));
    }

}