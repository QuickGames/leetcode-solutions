package java_problems.easy.p2812_find_the_maximum_achievable_number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("2769. Find the Maximum Achievable Number")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(4, 1, 6),
                Arguments.of(3, 2, 7)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void containsDuplicate(int num, int t, int expected) {
        Solution solution = new Solution();
        int actual = solution.theMaximumAchievableX(num, t);
        assertEquals(expected, actual);
    }

}