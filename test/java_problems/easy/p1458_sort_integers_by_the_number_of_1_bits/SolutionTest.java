package java_problems.easy.p1458_sort_integers_by_the_number_of_1_bits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("1356. Sort Integers by The Number of 1 Bits")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8},
                        new int[]{0, 1, 2, 4, 8, 3, 5, 6, 7}),
                Arguments.of(new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1},
                        new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024})
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int[] arr, int[] expected) {
        Solution sol = new Solution();
        int[] actual = sol.sortByBits(arr);

        Assertions.assertArrayEquals(expected, actual);
    }

}