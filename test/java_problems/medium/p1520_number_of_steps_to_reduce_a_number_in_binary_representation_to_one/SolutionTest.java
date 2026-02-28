package java_problems.medium.p1520_number_of_steps_to_reduce_a_number_in_binary_representation_to_one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("1404. Number of Steps to Reduce a Number in Binary Representation to One")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of("10000000000000000000000000000", 28),
                Arguments.of("11111111111111111111111111111", 30),
                Arguments.of("1101", 6), // 13 -> 14 -> 7 -> 8 -> 4 -> 2 -> 1
                // 0.  1101  13
                // 1.  1110  14
                // 2.  111   7
                // 3. 1000   8
                // 4. 100    4
                // 5. 10     2
                // 6. 1      1
                Arguments.of("10", 1),   // 2 -> 1
                Arguments.of("1", 0)     // уже 1
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void addTwoNumbersTest(String s, int expected) {
        Solution sol = new Solution();
        int actual = sol.numSteps(s);
        Assertions.assertEquals(expected, actual,
                String.format("Steps mismatch for s=\"%s\"! Expected: %d, but got: %d", s, expected, actual));
    }

}