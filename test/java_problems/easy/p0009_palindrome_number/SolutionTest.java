package java_problems.easy.p0009_palindrome_number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("9. Palindrome Number")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(121, true),
                Arguments.of(-121, false),
                Arguments.of(10, false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void lengthOfLastWord(int x, boolean expected) {
        Solution solution = new Solution();
        boolean actual = solution.isPalindrome(x);
        assertEquals(expected, actual);
    }

}