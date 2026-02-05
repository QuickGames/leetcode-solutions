package java_problems.easy.p0058_length_of_last_word;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("58. Length of Last Word")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of("Hello World", 5),
                Arguments.of("   fly me   to   the moon  ", 4),
                Arguments.of("luffy is still joyboy", 6)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void lengthOfLastWord(String s, int expected) {
        Solution solution = new Solution();
        int actual = solution.lengthOfLastWord(s);
        assertEquals(expected, actual);
    }

}