package java_problems.hard.p0060;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("60. Permutation Sequence")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(9, 4234, "128945673"),

                Arguments.of(3, 3, "213"),
                Arguments.of(4, 9, "2314"),
                Arguments.of(3, 1, "123")
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int n, int k, String expected) {
        Assertions.assertEquals(expected, new Solution().getPermutation(n, k));}

}