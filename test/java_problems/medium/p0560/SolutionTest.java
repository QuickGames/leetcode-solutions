package java_problems.medium.p0560;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("560. Subarray Sum Equals K")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 1}, 2, 2),
                Arguments.of(new int[]{1, 2, 3}, 3, 2),
                Arguments.of(new int[]{-1,-1,1}, 0, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int[] nums, int k, int expected) {
        Assertions.assertEquals(expected, new Solution().subarraySum(nums, k));
    }

}