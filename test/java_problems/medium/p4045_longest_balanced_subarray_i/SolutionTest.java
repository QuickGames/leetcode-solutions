package java_problems.medium.p4045_longest_balanced_subarray_i;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("3719. Longest Balanced Subarray I")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 2, 4}, 5),
                Arguments.of(new int[]{2, 5, 4, 3}, 4),
                Arguments.of(new int[]{3, 2, 2, 5, 4}, 5),
                Arguments.of(new int[]{1, 2, 3, 2}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void balanceBSTTest(int[] nums, int expected) {
        Solution solution = new Solution();
        Assertions.assertEquals(expected, solution.longestBalanced(nums));
    }

}