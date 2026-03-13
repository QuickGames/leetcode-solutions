package java_problems.medium.p1209;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

@DisplayName("1209. Remove All Adjacent Duplicates in String II")
class SolutionTest {

    static Stream<Arguments> provideData() throws IOException {
        return Stream.of(
                Arguments.of("aaabbb", 3, ""),
                Arguments.of("baab", 2, ""),

                Arguments.of("abcd", 2, "abcd"),
                Arguments.of("deeedbbcccbdaa", 3, "aa"),
                Arguments.of("pbbcggttciiippooaais", 2, "ps"),
                Arguments.of(Files.readString(Path.of("test/java_problems/medium/p1209/data20")), 2, "")
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(String s, int k, String expected) {
        Assertions.assertEquals(expected, new Solution().removeDuplicates(s, k));
    }

}