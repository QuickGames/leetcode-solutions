package java_problems.easy.p3379;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("3379. Transformed Array")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{3, -2, 1, 1}, new int[]{1, 1, 1, 3}),
                Arguments.of(new int[]{-1, 4, -1}, new int[]{-1, -1, 4})
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void constructTransformedArray(int[] nums, int[] expected) {
        Solution solution = new Solution();
        int[] actual = solution.constructTransformedArray(nums);
        assertArrayEquals(expected, actual, Arrays.toString(actual));
    }

}