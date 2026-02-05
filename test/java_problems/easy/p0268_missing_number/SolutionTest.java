package java_problems.easy.p0268_missing_number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("268. Missing Number")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{3, 0, 1}, 2),
                Arguments.of(new int[]{0, 1}, 2),
                Arguments.of(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}, 8),
                Arguments.of(new int[]{1}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void containsDuplicate(int[] nums, int expected) {
        Solution solution = new Solution();
        int actual = solution.missingNumber(nums);
        assertEquals(expected, actual);
    }

}