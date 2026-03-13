package java_problems.easy.p0020;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("20. Valid Parentheses")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of("()", true),
                Arguments.of("()[]{}", true),
                Arguments.of("(]", false),
                Arguments.of("([])", true),
                Arguments.of("([)]", false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(String s, boolean expected) {
        Assertions.assertEquals(expected, new Solution().isValid(s));
    }

}