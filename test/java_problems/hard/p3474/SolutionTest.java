package java_problems.hard.p3474;

import java_problems.SolutionTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("3474. Lexicographically Smallest Generated String")
class SolutionTest extends SolutionTestBase {

    static Stream<Arguments> provideData() {
        return Stream.of(

                Arguments.of("TFTF", "ab", "ababa"),
                Arguments.of("TFTF", "abc", ""),
                Arguments.of("F", "d", "a"),

                Arguments.of("TTFFT", "fff", "")

        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(String str1, String str2, String expected) {
        Assertions.assertEquals(expected, new Solution().generateString(str1, str2));
    }

}