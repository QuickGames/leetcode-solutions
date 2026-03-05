package java_problems.easy.p1884_minimum_changes_to_make_alternating_binary_string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("1758. Minimum Changes To Make Alternating Binary String")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                // Ex 1: "0100" -> "0101" (1 change)
                Arguments.of("0100", 1),
                // Ex 2: "10" is already alternating (0 changes)
                Arguments.of("10", 0),
                // Ex 3: "1111" -> "1010" or "0101" (2 changes)
                Arguments.of("1111", 2)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(String s, int expected) {
        Assertions.assertEquals(expected, new Solution().minOperations(s));
    }

}