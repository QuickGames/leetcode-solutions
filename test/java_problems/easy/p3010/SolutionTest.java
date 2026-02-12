package java_problems.easy.p3010;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("3010. Divide an Array Into Subarrays With Minimum Cost I")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 12}, 6),
                Arguments.of(new int[]{5, 4, 3}, 12),
                Arguments.of(new int[]{10, 3, 1, 1}, 12),
                Arguments.of(new int[]{1, 6, 1, 5}, 7),
                Arguments.of(new int[]{1, 26, 22, 2, 6, 32, 8, 36, 7, 47}, 9)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int[] nums, int expected) {
        Solution solution = new Solution();
        Assertions.assertEquals(expected, solution.minimumCost(nums));
    }

}