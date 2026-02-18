package java_problems.medium.p0394_decode_string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("394. Decode String")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of("3[a]2[bc]", "aaabcbc"),
                Arguments.of("3[a2[c]]", "accaccacc"),
                Arguments.of("2[abc]3[cd]ef", "abcabccdcdcdef")
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(String s, String expected) {
        Solution solution = new Solution();
        Assertions.assertEquals(expected, solution.decodeString(s));
    }

}