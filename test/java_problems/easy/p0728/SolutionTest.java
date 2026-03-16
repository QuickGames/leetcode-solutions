package java_problems.easy.p0728;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

@DisplayName("728. Self Dividing Numbers")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(1, 10000, null),

                Arguments.of(1, 22, List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22)),
                Arguments.of(47, 85, List.of(48, 55, 66, 77))
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int left, int right, List<Integer> expected) {
        List<Integer> actual = new Solution().selfDividingNumbers(left, right);
        if (expected != null) Assertions.assertEquals(expected, actual);
    }

}