package java_problems.medium.p0443_string_compression;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("443. String Compression")
class SolutionTest {
    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(
                        new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'},
                        6,
                        new char[]{'a', '2', 'b', '2', 'c', '3'}
                ),
                Arguments.of(
                        new char[]{'a'},
                        1,
                        new char[]{'a'}
                ),
                Arguments.of(
                        new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'},
                        4,
                        new char[]{'a', 'b', '1', '2'}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(char[] chars, int expectedLen, char[] expectedChars) {
        Solution solution = new Solution();
        int actualLen = solution.compress(chars);

        Assertions.assertEquals(expectedLen, actualLen,
                String.format("Length mismatch! Expected: %d, but got: %d", expectedLen, actualLen));
        for (int i = 0; i < expectedLen; i++) {
            Assertions.assertEquals(expectedChars[i], chars[i], "Mismatch at index " + i);
        }

    }

}