package java_problems.medium.p0152_maximum_product_subarray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("152. Maximum Product Subarray")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{-5, 0, 8, 1, -2, -4, 0, 4, -9, 2, 0, 6, -2, 1, -1, -3, 7, 0, 5, -1, 2, 9, -7}, 630),
                Arguments.of(new int[]{-3, -2}, 6),
                Arguments.of(new int[]{-2}, -2),

                Arguments.of(new int[]{2, 3, -2, 4}, 6),
                Arguments.of(new int[]{-2, 0, -1}, 0),
                Arguments.of(new int[]{0}, 0),
                Arguments.of(new int[]{-2, 0}, 0),
                Arguments.of(new int[]{-3, 0, 1, -2}, 1),
                Arguments.of(new int[]{1, -2, 3, -4, -3, -4, -3}, 432)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int[] nums, int expected) {
        Assertions.assertEquals(expected, new Solution().maxProduct(nums));
    }

}