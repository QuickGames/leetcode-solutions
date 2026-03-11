package java_problems.medium.p0011_container_with_most_water;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("11. Container With Most Water")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                // Ex 1: Max area 49
                Arguments.of(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                // Ex 2: Max area 1
                Arguments.of(new int[]{1, 1}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int[] height, int expected) {
        Assertions.assertEquals(expected, new Solution().maxArea(height));
    }

}