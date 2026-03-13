package java_problems.medium.p0022;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

@DisplayName("22. Generate Parentheses")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(3, 5),
                Arguments.of(4, 14),
                Arguments.of(5, 42),
                Arguments.of(6, 132),
                Arguments.of(7, 429),
                Arguments.of(8, 1430)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int n, int expected) {
        List<String> actual = new Solution().generateParenthesis(n);
        Assertions.assertEquals(expected, actual.size());
    }

}