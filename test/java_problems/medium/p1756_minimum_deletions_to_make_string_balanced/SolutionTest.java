package java_problems.medium.p1756_minimum_deletions_to_make_string_balanced;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("1653. Minimum Deletions to Make String Balanced")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of("aababbab", 2),
                Arguments.of("bbaaaaabb", 2),
                Arguments.of("baababbaabbaaabaabbabbbabaaaaaabaabababaaababbb", 18),
                Arguments.of("a", 0),
                Arguments.of("b", 0),
                Arguments.of("ababaaaabbbbbaaababbbbbbaaabbaababbabbbbaabbbbaabbabbabaabbbababaa", 25),
                Arguments.of("aaabbb", 0),
                Arguments.of("bbbaaa", 3),
                Arguments.of("ababababab", 4),
                Arguments.of("bababababa", 5)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void constructTransformedArray(String s, int expected) {
        Solution solution = new Solution();
        Assertions.assertEquals(expected, solution.minimumDeletions(s));
    }

}