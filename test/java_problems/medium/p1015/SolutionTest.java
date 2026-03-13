package java_problems.medium.p1015;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("1015. Smallest Integer Divisible by K")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, -1),
                Arguments.of(3, 3),
                Arguments.of(5, -1),
                Arguments.of(7, 6),
                Arguments.of(9, 9),
                Arguments.of(23, 22),
                Arguments.of(99989, 99988),
                Arguments.of(99_999, 45),
                Arguments.of(199_999, 99999)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int k, int expected) {
        Assertions.assertEquals(expected, new Solution().smallestRepunitDivByK(k));
    }

}