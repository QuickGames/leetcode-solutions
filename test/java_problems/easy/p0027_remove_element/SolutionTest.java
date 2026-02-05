package java_problems.easy.p0027_remove_element;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("27. Remove Element")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 2, 3}, 3, 2, new int[]{2, 2}),
                Arguments.of(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2, 5, new int[]{0, 1, 3, 0, 4}));
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void containsDuplicate(int[] nums, int val, int expected, int[] expectedNums) {
        Solution solution = new Solution();
        int actual = solution.removeElement(nums, val);
        assertEquals(expected, actual);
        int[] actualSubArray = Arrays.copyOfRange(nums, 0, actual);
        assertArrayEquals(expectedNums, actualSubArray);
    }

}