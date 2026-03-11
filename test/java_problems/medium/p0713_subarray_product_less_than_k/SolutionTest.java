package java_problems.medium.p0713_subarray_product_less_than_k;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

@DisplayName("152. Maximum Product Subarray")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{10, 5, 2, 6}, 100, 8),
                Arguments.of(new int[]{1, 2, 3}, 0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int[] nums, int k, int expected) {
        Assertions.assertEquals(expected, new Solution().numSubarrayProductLessThanK(nums, k));
    }

    @Test
    void solutionTestRandom() {
        Random random = new Random();
        int[] nums = new int[30_000];
        for (int i = 0; i < 30_000; i++)
            nums[i] = random.nextInt(1000) + 1;
        int k = random.nextInt(1_000_000) + 1;
        Solution solution = new Solution();
        int actual = solution.numSubarrayProductLessThanK(nums, k);
        Assertions.assertTrue(0 <= actual);
    }

}