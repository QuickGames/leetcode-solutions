package java_problems.medium.p2571;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("1386. Cinema Seat Allocation")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(39, 3),
                Arguments.of(54, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int n, int expected) {
        Assertions.assertEquals(expected, new Solution().minOperations(n));
    }

}