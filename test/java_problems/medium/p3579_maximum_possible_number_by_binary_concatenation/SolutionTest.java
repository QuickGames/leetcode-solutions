package java_problems.medium.p3579_maximum_possible_number_by_binary_concatenation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("3309. Maximum Possible Number by Binary Concatenation")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                // [3, 1, 2] -> "11110" -> 30
                Arguments.of(new int[]{1, 2, 3}, 30),
                // [2, 8, 16] -> "10100010000" -> 1296
                Arguments.of(new int[]{2, 8, 16}, 1296),
                Arguments.of(new int[]{1, 11, 5}, 221),
                Arguments.of(new int[]{2, 91, 119}, 61294)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void arrayPowerSumTest(int[] nums, int expected) {
        Solution sol = new Solution();
        int actual = sol.maxGoodNumber(nums); // Подставь реальное имя

        Assertions.assertEquals(expected, actual,
                String.format("Result mismatch! Expected: %d, but got: %d", expected, actual));
    }

}