package java_problems.medium.p0008_string_to_integer_atoi;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("8. String to Integer (atoi)")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of("42", 42),
                Arguments.of(" -042", -42),
                Arguments.of("1337c0d3", 1337)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void lengthOfLastWord(String s, int expected) {
        Solution solution = new Solution();
        int actual = solution.myAtoi(s);
        assertEquals(expected, actual);
    }

}