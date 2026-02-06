package java_problems.easy.p0035_search_insert_position;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("35. Search Insert Position")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 5, 6}, 5, 2),
                Arguments.of(new int[]{1, 3, 5, 6}, 2, 1),
                Arguments.of(new int[]{1, 3, 5, 6}, 7, 4),
                Arguments.of(new int[]{1, 3, 5}, 1, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void constructTransformedArray(int[] nums, int target, int expected) {
        Solution solution = new Solution();
        int actual = solution.searchInsert(nums, target);
        Assertions.assertEquals(expected, actual);
    }

}