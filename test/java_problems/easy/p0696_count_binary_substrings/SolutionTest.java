package java_problems.easy.p0696_count_binary_substrings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("696. Count Binary Substrings")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of("011011", 3),
                Arguments.of("00110011", 6),
                Arguments.of("10101", 4)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(String s, int expected) {
        Solution solution = new Solution();
        Assertions.assertEquals(expected, solution.countBinarySubstrings(s));
    }

}