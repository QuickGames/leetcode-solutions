package java_problems.medium.p0056_merge_intervals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("56. Merge Intervals")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 4}, {6, 9}, {3, 8}, {10, 12}}, new int[][]{{1, 9}, {10, 12}}),

                // Ex 1: Overlapping intervals [1,3] and [2,6]
                Arguments.of(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}, new int[][]{{1, 6}, {8, 10}, {15, 18}}),
                // Ex 2: Overlapping at boundary [1,4] and [4,5]
                Arguments.of(new int[][]{{1, 4}, {4, 5}}, new int[][]{{1, 5}}),
                // Ex 3: Unsorted overlapping intervals
                Arguments.of(new int[][]{{4, 7}, {1, 4}}, new int[][]{{1, 7}}),
                Arguments.of(new int[][]{{1, 4}, {5, 6}}, new int[][]{{1, 4}, {5, 6}})
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int[][] intervals, int[][] expected) {
        // Sort intervals by start time before merging
        int[][] actual = new Solution().merge(intervals);
        Assertions.assertArrayEquals(expected, actual);
    }

}