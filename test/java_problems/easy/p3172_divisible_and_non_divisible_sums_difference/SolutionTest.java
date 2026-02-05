package java_problems.easy.p3172_divisible_and_non_divisible_sums_difference;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("2894. Divisible and Non-divisible Sums Difference")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(10, 3, 19),
                Arguments.of(5, 1, -15)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void constructTransformedArray(int n, int m, int expected) {
        Solution solution = new Solution();
        int actual = solution.differenceOfSums(n, m);
        assertEquals(expected, actual);
    }

}