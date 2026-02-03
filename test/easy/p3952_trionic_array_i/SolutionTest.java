package easy.p3952_trionic_array_i;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("3637. Trionic Array I")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 5, 4, 2, 6}, true),
                Arguments.of(new int[]{2, 1, 3}, false),
                Arguments.of(new int[]{}, false),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, false),
                Arguments.of(new int[]{5, 4, 3, 2}, false),
                Arguments.of(new int[]{1, 6, 6, 3, 7}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void containsDuplicate(int[] nums, boolean expected) {
        Solution solution = new Solution();
        boolean actual = solution.isTrionic(nums);
        assertEquals(expected, actual);
    }

}