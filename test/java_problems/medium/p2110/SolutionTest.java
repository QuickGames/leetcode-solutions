package java_problems.medium.p2110;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("2110. Number of Smooth Descent Periods of a Stock")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 1, 4}, 7L),
                Arguments.of(new int[]{8, 6, 7, 7}, 4L),
                Arguments.of(new int[]{1}, 1L)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int[] prices, long expected) {
        Assertions.assertEquals(expected, new Solution().GetDescentPeriods(prices));
    }

}