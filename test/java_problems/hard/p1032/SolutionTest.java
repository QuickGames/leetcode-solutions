package java_problems.hard.p1032;

import java_problems.SolutionTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

@DisplayName("1032. Stream of Characters")
class SolutionTest extends SolutionTestBase {

    static Stream<Arguments> provideData() throws IOException {
        return Stream.of(

                Arguments.of(
                        new String[]{"StreamChecker", "query", "query", "query", "query"},
                        new String[][]{{"abc", "xyz"}, {"a"}, {"x"}, {"y"}, {"z"}},
                        new Boolean[]{null, false, false, false, true}
                ),

                Arguments.of(
                        new String[]{"StreamChecker", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query"},
                        new String[][]{{"cd", "f", "kl"}, {"a"}, {"b"}, {"c"}, {"d"}, {"e"}, {"f"}, {"g"}, {"h"}, {"i"}, {"j"}, {"k"}, {"l"}},
                        new Boolean[]{null, false, false, false, true, false, true, false, false, false, false, false, true}
                ),

                Arguments.of(
                        new String[]{"StreamChecker", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query"},
                        new String[][]{{"ab", "ba", "aaab", "abab", "baa"}, {"a"}, {"a"}, {"a"}, {"a"}, {"a"}, {"b"}, {"a"}, {"b"}, {"a"}, {"b"}, {"b"}, {"b"}, {"a"}, {"b"}, {"a"}, {"b"}, {"b"}, {"b"}, {"b"}, {"a"}, {"b"}, {"a"}, {"b"}, {"a"}, {"a"}, {"a"}, {"b"}, {"a"}, {"a"}, {"a"}},
                        new Boolean[]{null, false, false, false, false, false, true, true, true, true, true, false, false, true, true, true, true, false, false, false, true, true, true, true, true, true, false, true, true, true, false}
                ),
                Arguments.of(
                        readStringArray("data19_commands"),
                        readStringGrid("data19_params"),
                        readBooleanArray("data19_expected")
                ),
                Arguments.of(
                        readStringArray("data16_commands"),
                        readStringGrid("data16_params"),
                        readBooleanArray("data16_expected")
                )

        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(String[] commands, String[][] params, Boolean[] expected) {
        StreamChecker streamChecker = new StreamChecker(params[0]);
        for (int i = 1; i < commands.length; i++) {
            if (commands[i].equals("query")) {
                Assertions.assertEquals(expected[i], streamChecker.query(params[i][0].charAt(0)));
            }
        }
    }

}