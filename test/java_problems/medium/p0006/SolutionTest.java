package java_problems.medium.p0006;

import java_problems.SolutionTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("6. Zigzag Conversion")
class SolutionTest extends SolutionTestBase {

    static Stream<Arguments> provideData() {
        return Stream.of(

                Arguments.of("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"),
                Arguments.of("PAYPALISHIRING", 4, "PINALSIGYAHRPI"),
                Arguments.of("A", 1, "A"),

                Arguments.of("AB", 1, "AB")

        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(String s, int numRows, String expected) {
        Assertions.assertEquals(expected, new Solution().convert(s, numRows));
    }

}