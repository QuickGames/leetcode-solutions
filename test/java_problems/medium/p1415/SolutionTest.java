package java_problems.medium.p1415;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("1415. The k-th Lexicographical String of All Happy Strings of Length n")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(10, 100, "abacbabacb"),
                Arguments.of(3, 4, "acb"),
                Arguments.of(3, 5, "bab"),

                Arguments.of(1, 3, "c"),
                Arguments.of(1, 4, ""),
                Arguments.of(3, 9, "cab"),
                Arguments.of(1, 1, "a")
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int n, int k, String expected) {
        Assertions.assertEquals(expected, new Solution().getHappyString(n, k));
    }

}