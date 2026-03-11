package java_problems.hard.p0042_trapping_rain_water;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("42. Trapping Rain Water")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}, 6),
                Arguments.of(new int[]{4,2,0,3,2,5}, 9)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int[] height, int expected) {
        Assertions.assertEquals(expected, new Solution().trap(height));
    }

}