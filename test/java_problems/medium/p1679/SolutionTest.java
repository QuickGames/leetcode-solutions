package java_problems.medium.p1679;

import java_problems.SolutionTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("1679. Max Number of K-Sum Pairs")
class SolutionTest extends SolutionTestBase {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, 5, 2),
                Arguments.of(new int[]{3, 1, 3, 4, 3}, 6, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int[] nums, int k, int expected) {
        Assertions.assertEquals(expected, new Solution().maxOperations(nums, k));
    }

}