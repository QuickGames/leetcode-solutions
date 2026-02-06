package java_problems.easy.p1448_maximum_69_number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("1323. Maximum 69 Number")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(9669, 9969),
                Arguments.of(9996, 9999),
                Arguments.of(9999, 9999)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void constructTransformedArray(int num, int expected) {
        Solution solution = new Solution();
        Assertions.assertEquals(expected, solution.maximum69Number(num));
    }

}