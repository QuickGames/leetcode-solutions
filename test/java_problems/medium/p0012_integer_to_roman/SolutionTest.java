package java_problems.medium.p0012_integer_to_roman;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("12. Integer to Roman")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(3749, "MMMDCCXLIX"),
                Arguments.of(58, "LVIII"),
                Arguments.of(1994, "MCMXCIV")
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void lengthOfLastWord(int num, String expected) {
        Solution solution = new Solution();
        String actual = solution.intToRoman(num);
        assertEquals(expected, actual);
    }

}