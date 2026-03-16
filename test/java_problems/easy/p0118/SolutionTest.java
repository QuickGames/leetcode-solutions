package java_problems.easy.p0118;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

@DisplayName("118. Pascal's Triangle")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(5, List.of(List.of(1), List.of(1, 1), List.of(1, 2, 1), List.of(1, 3, 3, 1), List.of(1, 4, 6, 4, 1))),
                Arguments.of(1, List.of(List.of(1)))
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int numRows, List<List<Integer>> expected) {
        Assertions.assertEquals(expected, new Solution().generate(numRows));
    }

}