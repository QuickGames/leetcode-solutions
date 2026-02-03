package medium.p50_powx_n;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("Math")
@Tag("Recursion")
@DisplayName("50. Pow(x, n)")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(2, -2147483648, 0),
                Arguments.of(2, 7, 128),
                Arguments.of(2.0, 10, 1024.0),
                Arguments.of(2.1, 3, 9.261),
                Arguments.of(2.0, -2, 0.25),
                Arguments.of(1.0, 0, 1.0),
                Arguments.of(10.0, 0, 1.0),
                Arguments.of(-2.0, 2, 4.0),
                Arguments.of(-2.0, 3, -8.0),
                Arguments.of(-2.0, -3, -0.125),
                Arguments.of(1.0, 2147483647, 1.0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void myPow(double x, int n, double expected) {
        Solution solution = new Solution();
        double actual = solution.myPow(x, n);
        assertEquals(expected, actual, 0.00001);
    }

}