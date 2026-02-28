package java_problems.medium.p1800_concatenation_of_consecutive_binary_numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("1680. Concatenation of Consecutive Binary Numbers")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(100, 310828084),
                Arguments.of(1000, 356435599),
                Arguments.of(10000, 757631812),

                Arguments.of(1, 1),
                Arguments.of(3, 27),
                Arguments.of(12, 505379714)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void pairSumTest(int n, int expected) {
        Solution sol = new Solution();
        int actual = sol.concatenatedBinary(n);

        Assertions.assertEquals(expected, actual,
                String.format("Calculation error for n=%d! Expected: %d, but got: %d", n, expected, actual));
    }

}