package java_problems.medium.p0347;

import java_problems.SolutionTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

@DisplayName("347. Top K Frequent Elements")
class SolutionTest extends SolutionTestBase {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 1, 2, 2, 3}, 2, new int[]{1, 2}),
                Arguments.of(new int[]{1}, 1, new int[]{1}),
                Arguments.of(new int[]{1, 2, 1, 2, 1, 2, 3, 1, 3, 2}, 2, new int[]{1, 2})
        );

    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int[] nums, int k, int[] expected) {
        int[] actual = new Solution().topKFrequent(nums, k);
        Arrays.sort(actual);
        Arrays.sort(expected);
        Assertions.assertArrayEquals(expected, actual);
    }
}