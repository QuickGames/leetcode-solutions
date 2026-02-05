package java_problems.hard.p0004_median_of_two_sorted_arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("4. Median of Two Sorted Arrays")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{1, 3}, new int[]{2}, 2.00000),
                Arguments.of(new int[]{1, 2}, new int[]{3, 4}, 2.50000)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void containsDuplicate(int[] nums1, int[] nums2, double expected) {
        Solution solution = new Solution();
        double actual = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, actual);
    }

}