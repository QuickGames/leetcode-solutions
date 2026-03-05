package java_problems.medium.p1667_find_kth_bit_in_nth_binary_string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("1545. Find Kth Bit in Nth Binary String")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(20, 11, '1'),
                Arguments.of(20, 1_000_000, '1'),
                Arguments.of(20, 1_048_575, '1'),

                Arguments.of(3, 1, '0'),
                Arguments.of(4, 11, '1')
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int n, int k, char expected) {
        Solution sol = new Solution();
        char actual = sol.findKthBit(n, k);
        Assertions.assertEquals(expected, actual);
    }

}