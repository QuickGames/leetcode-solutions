package java_problems.medium.p0003_longest_substring_without_repeating_characters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("1536. Minimum Swaps to Arrange a Binary Grid")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                // "abc" -> 3
                Arguments.of("abcabcbb", 3),
                // "b" -> 1
                Arguments.of("bbbbb", 1),
                // "wke" -> 3
                Arguments.of("pwwkew", 3)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(String s, int expected) {
        Solution sol = new Solution();
        int actual = sol.lengthOfLongestSubstring(s);
        Assertions.assertEquals(expected, actual, "Substring length mismatch!");
    }

}