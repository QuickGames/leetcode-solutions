package java_problems.easy.p0228;

import java_problems.SolutionTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

@DisplayName("228. Summary Ranges")
class SolutionTest extends SolutionTestBase {

    static Stream<Arguments> provideData() {
        return Stream.of(

                Arguments.of(new int[]{1, 2, 3, 4, 6, 8, 9}, List.of("1->4", "6", "8->9")),
                Arguments.of(new int[]{}, List.of()),

                Arguments.of(new int[]{0, 1, 2, 4, 5, 7}, List.of("0->2", "4->5", "7")),
                Arguments.of(new int[]{0, 2, 3, 4, 6, 8, 9}, List.of("0", "2->4", "6", "8->9")),

                Arguments.of(new int[]{-2147483648, 0, 2, 3, 4, 6, 8, 9}, List.of("-2147483648", "0", "2->4", "6", "8->9")),
                Arguments.of(new int[]{-1}, List.of("-1")),
                Arguments.of(new int[]{-2147483648, -2147483647, 2147483647}, List.of("-2147483648->-2147483647", "2147483647"))

        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int[] nums, List<String> expected) {
        Assertions.assertEquals(expected, new Solution().summaryRanges(nums));
    }

}