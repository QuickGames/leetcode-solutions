package java_problems.medium.p0005;

import java_problems.SolutionTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("5. Longest Palindromic Substring")
class SolutionTest extends SolutionTestBase {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of("babad", "bab"),
                Arguments.of("cbbd", "bb")
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(String s, String expected) {
        Assertions.assertEquals(expected, new Solution().longestPalindrome(s));
    }

}