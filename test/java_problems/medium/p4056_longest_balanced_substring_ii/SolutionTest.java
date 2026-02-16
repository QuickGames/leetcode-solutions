package java_problems.medium.p4056_longest_balanced_substring_ii;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@DisplayName("3714. Longest Balanced Substring II")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of("ababcaacc", 4),
                Arguments.of("bcbcabbaa", 4),
                Arguments.of("cacabccbb", 4),
                Arguments.of("aaaaaaaaaa", 10),
                Arguments.of("bbbbbbbbbb", 10),
                Arguments.of("cccccccccc", 10),
                Arguments.of("abbac", 4),
                Arguments.of("aabcc", 3),
                Arguments.of("aba", 2),
                Arguments.of("a", 1),
                Arguments.of("b", 1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(String s, int expected) {
        Solution solution = new Solution();
        Assertions.assertEquals(expected, solution.longestBalanced(s));
    }

    static Stream<Arguments> getLargeArrayProvider(String first, int expected) throws IOException {
        String content = Files.readString(Paths.get(first)).trim();
        return Stream.of(Arguments.of(content, expected));
    }

    static Stream<Arguments> largeArrayProvider983() throws IOException {
        return getLargeArrayProvider("test/java_problems/medium/p3714/data986.csv", 15828);
    }

    @ParameterizedTest
    @MethodSource("largeArrayProvider983")
    void constructTransformedArray983(String s, int expected) {
        Solution solution = new Solution();
        Assertions.assertEquals(expected, solution.longestBalanced(s));
    }

    static Stream<Arguments> largeArrayProvider992() throws IOException {
        return getLargeArrayProvider("test/java_problems/medium/p3714/data992.csv", 99999);
    }

    @ParameterizedTest
    @MethodSource("largeArrayProvider992")
    void constructTransformedArray992(String s, int expected) {
        Solution solution = new Solution();
        Assertions.assertEquals(expected, solution.longestBalanced(s));
    }

}