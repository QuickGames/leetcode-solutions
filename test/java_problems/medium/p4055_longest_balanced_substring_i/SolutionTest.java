package java_problems.medium.p4055_longest_balanced_substring_i;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("3713. Longest Balanced Substring I")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of("abbac", 4),
                Arguments.of("zzabccy", 4),
                Arguments.of("aba", 2),
                Arguments.of("a", 1),
                Arguments.of("b", 1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(String s, int expected) {
        Solution solution = new Solution();
        Assertions.assertEquals(expected, solution.longestBalanced(s));
    }

}