package java_problems.medium.p0198_house_robber;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("198. House Robber")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(

                Arguments.of(new int[]{1, 7, 9, 7, 1, 2, 6}, 20),

                // Ex 1: 1 + 3 = 4
                Arguments.of(new int[]{1, 2, 3, 1}, 4),
                // Ex 2: 2 + 9 + 1 = 12
                Arguments.of(new int[]{2, 7, 9, 3, 1}, 12)

        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int[] nums, int expected) {
        // Return max money without robbing adjacent houses
        Assertions.assertEquals(expected, new Solution().rob(nums));
    }

}