package java_problems.medium.p0238_product_of_array_except_self;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

@DisplayName("238. Product of Array Except Self")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 0, 0, 3, 4}, new int[]{0, 0, 0, 0, 0, 0}),

                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{24, 12, 8, 6}),
                Arguments.of(new int[]{-1, 1, 0, -3, 3}, new int[]{0, 0, 9, 0, 0}),
                Arguments.of(new int[]{1, -1}, new int[]{-1, 1}),
                Arguments.of(new int[]{5, 9, 2, -9, -9, -7, -8, 7, -9, 10}, new int[]{-51438240, -28576800, -128595600, 28576800, 28576800, 36741600, 32148900, -36741600, 28576800, -25719120})
        );
    }

    static Stream<Arguments> provideDataRandom() {
        Random random = new Random();
        int[] nums = new int[100_000];
        for (int i = 0; i < 100_000; i++) {
            int probability = random.nextInt(10000);
            nums[i] = switch (probability) {
                case 0 -> 3;
                case 1 -> 2;
                default -> 1;
            };
            if (random.nextBoolean()) nums[i] = -nums[i];
        }
        return Stream.of(Arguments.of((Object) nums));
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int[] nums, int[] expected) {
        Assertions.assertArrayEquals(expected, new Solution().productExceptSelf(nums));
    }

    @ParameterizedTest
    @MethodSource("provideDataRandom")
    void solutionTestRandom(int[] nums) {
        Assertions.assertNotNull(new Solution().productExceptSelf(nums));
    }

}