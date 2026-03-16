package java_problems.medium.p1249;

import java_problems.SolutionTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("1249. Minimum Remove to Make Valid Parentheses")
class SolutionTest extends SolutionTestBase {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of("lee(t(c)o)de)", "lee(t(c)o)de"),
                Arguments.of("a)b(c)d", "ab(c)d"),
                Arguments.of("))((", "")
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(String s, String expected) {
        Assertions.assertEquals(expected, new Solution().minRemoveToMakeValid(s));
    }

}