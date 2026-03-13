package java_problems.medium.p0207;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("207. Course Schedule")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(2, new int[][]{{1, 0}}, true),
                Arguments.of(2, new int[][]{{1, 0}, {0, 1}}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int numCourses, int[][] prerequisites, boolean expected) {
        Assertions.assertEquals(expected, new Solution().canFinish(numCourses, prerequisites));
    }

}