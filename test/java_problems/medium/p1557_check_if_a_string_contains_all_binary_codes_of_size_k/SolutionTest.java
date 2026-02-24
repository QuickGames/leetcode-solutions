package java_problems.medium.p1557_check_if_a_string_contains_all_binary_codes_of_size_k;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("1461. Check If a String Contains All Binary Codes of Size K")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of("00110", 2, true),
                Arguments.of("000111010100", 3, true),
                Arguments.of("00110110", 2, true),
                Arguments.of("0110", 1, true),
                Arguments.of("0110", 2, false),
                Arguments.of("00011010111101010111110111011110101001111001111100010010010001111001000010010010001110010000111000010001001000010011111111100010111011101101111100001110001110101110101001110000010101100100100010100110101110110001000011011011000111001101111000000010101110110100110001100010111111110101010001111000001110000000011111101011011111011110001100011100001011000000111101011100011011111110001010001111110100011110101101101011100100000100110011110111011000001010111011100011000100001000000111101001101010010000111110001110111100100110000101001011010101010101000100011000111100100101100010100111100111000010110011011110110001100101010101111001011000000010", 19, false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(String s, int k, boolean expected) {
        Solution solution = new Solution();
        boolean actual = solution.hasAllCodes(s, k);
        Assertions.assertEquals(expected, actual,
                String.format("Failed for s=\"%s\" and k=%d. Expected %b, but got %b", s, k, expected, actual));
    }

}