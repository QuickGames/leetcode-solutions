package java_problems.medium.p0007_reverse_integer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("7. Reverse Integer")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(123, 321),
                Arguments.of(-123, -321),
                Arguments.of(120, 21)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void lengthOfLastWord(int x, int expected) {
        Solution solution = new Solution();
        int actual = solution.reverse(x);
        assertEquals(expected, actual);
    }

}