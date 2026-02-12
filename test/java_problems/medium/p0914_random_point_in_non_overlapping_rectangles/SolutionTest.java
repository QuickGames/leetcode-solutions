package java_problems.medium.p0914_random_point_in_non_overlapping_rectangles;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("497. Random Point in Non-overlapping Rectangles")
class SolutionTest {

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int[][] rects) {
        Solution sol = new Solution(rects);

        for (int i = 0; i < 1000; i++) {
            int[] point = sol.pick();
            int x = point[0];
            int y = point[1];

            boolean found = false;
            for (int[] r : rects) {
                if (x >= r[0] && x <= r[2] && y >= r[1] && y <= r[3]) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                Assertions.fail("Point [" + x + ", " + y + "] is not in the rectangles");
            }
        }
    }

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of((Object) new int[][]{{-2, -2, 1, 1}, {2, 2, 4, 6}})
        );
    }

}