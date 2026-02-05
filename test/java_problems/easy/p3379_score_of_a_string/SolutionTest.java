package java_problems.easy.p3379_score_of_a_string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("3110. Score of a String")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of("hello", 13),
                Arguments.of("zaz", 50),
                Arguments.of("a", 0),
                Arguments.of("aaaaa", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void containsDuplicate(String s, int expected) {
        Solution solution = new Solution();
        int actual = solution.scoreOfString(s);
        assertEquals(expected, actual);
    }

}