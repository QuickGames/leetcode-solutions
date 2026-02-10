package java_problems.medium.p0398;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("398. Random Pick Index")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 3, 3, 3},
                        new int[]{3, 1, 3},
                        new int[]{4, 0, 2}
                ),
                Arguments.of(
                        new int[]{1, 1, 1},
                        new int[]{1},
                        new int[]{1}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void pickTest(int[] nums, int[] targets) {
        Solution sol = new Solution(nums);
        for (int target : targets) {
            int resultIndex = sol.pick(target);
            Assertions.assertTrue(resultIndex >= 0 && resultIndex < nums.length,
                    "Index " + resultIndex + " is out of bounds");
            Assertions.assertEquals(target, nums[resultIndex],
                    "Wrong pick! At index " + resultIndex + " we found " + nums[resultIndex] + " instead of " + target);
        }
    }

}