package java_problems.medium.p0815_champagne_tower;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("799. Champagne Tower")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(1, 1, 1, 0.0d),
                Arguments.of(2, 1, 1, 0.5d),
                Arguments.of(100000009, 33, 17, 1.0d),
                Arguments.of(1, 0, 0, 1.0d),
                Arguments.of(2, 0, 0, 1.0d)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int poured, int query_row, int query_glass, double expected) {
        Solution solution = new Solution();
        Assertions.assertEquals(expected, solution.champagneTower(poured, query_row, query_glass));
    }

}