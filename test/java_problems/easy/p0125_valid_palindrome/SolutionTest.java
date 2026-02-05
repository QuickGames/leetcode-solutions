package java_problems.easy.p0125_valid_palindrome;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("125. Valid Palindrome")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of("A man, a plan, a canal: Panama", true),
                Arguments.of("race a car", false),
                Arguments.of(" ", true)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void isPalindrome(String s, boolean expected) {
        Solution solution = new Solution();
        boolean actual = solution.isPalindrome(s);
        assertEquals(expected, actual);
    }

}