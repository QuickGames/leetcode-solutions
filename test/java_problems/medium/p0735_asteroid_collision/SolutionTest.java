package java_problems.medium.p0735_asteroid_collision;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("735. Asteroid Collision")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{5, 10, -5}, new int[]{5, 10}),
                Arguments.of(new int[]{8, -8}, new int[]{}),
                Arguments.of(new int[]{10, 2, -5}, new int[]{10}),
                Arguments.of(new int[]{3, 5, -6, 2, -1, 4}, new int[]{-6, 2, 4})
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int[] asteroids, int[] expected) {
        Solution sol = new Solution();
        int[] actual = sol.asteroidCollision(asteroids);

        Assertions.assertArrayEquals(expected, actual,
                "Asteroid survival mismatch!");
    }

}