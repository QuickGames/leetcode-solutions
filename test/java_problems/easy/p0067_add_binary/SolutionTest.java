package java_problems.easy.p0067_add_binary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("67. Add Binary")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of("11", "1", "100"),
                Arguments.of("1010", "1011", "10101")
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(String a, String b, String expected) {
        Solution solution = new Solution();
        Assertions.assertEquals(expected, solution.addBinary(a, b));
    }

}