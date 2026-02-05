package java_problems.easy.p0088_merge_sorted_array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("88. Merge Sorted Array")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3, new int[]{1, 2, 2, 3, 5, 6}),
                Arguments.of(new int[]{1}, 1, new int[]{}, 0, new int[]{1}),
                Arguments.of(new int[]{0}, 0, new int[]{1}, 1, new int[]{1})
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void mergeSortedArrayTest(int[] nums1, int m, int[] nums2, int n, int[] expected) {
        Solution solution = new Solution();
        solution.merge(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
    }

}