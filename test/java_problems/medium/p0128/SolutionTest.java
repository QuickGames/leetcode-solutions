package java_problems.medium.p0128;

import java_problems.SolutionTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("128. Longest Consecutive Sequence")
class SolutionTest extends SolutionTestBase {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{100, 4, 200, 1, 3, 2}, 4),
                Arguments.of(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}, 9),
                Arguments.of(new int[]{1, 0, 1, 2}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int[] nums, int expected) {
        Assertions.assertEquals(expected, new Solution().longestConsecutive(nums));
    }

}