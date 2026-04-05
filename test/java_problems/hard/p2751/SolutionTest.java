package java_problems.hard.p2751;

import java_problems.SolutionTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

@DisplayName("2751. Robot Collisions")
class SolutionTest extends SolutionTestBase {

    static Stream<Arguments> provideData() throws IOException {
        return Stream.of(

                Arguments.of(
                        new int[]{5, 4, 3, 2, 1},
                        new int[]{2, 17, 9, 15, 10},
                        "RRRRR",
                        List.of(2, 17, 9, 15, 10)
                ),
                Arguments.of(
                        new int[]{3, 5, 2, 6},
                        new int[]{10, 10, 15, 12},
                        "RLRL",
                        List.of(14)
                ),
                Arguments.of(
                        new int[]{1, 2, 5, 6},
                        new int[]{10, 10, 11, 11},
                        "RLRL",
                        List.of()
                ),

                Arguments.of(
                        readIntArray("data2428_positions"),
                        readIntArray("data2428_healths"),
                        readFileAsString("data2428_directions"),
                        List.of(readIntegerArray("data2428_expected"))
                ),
                Arguments.of(
                        readIntArray("data2429_positions"),
                        readIntArray("data2429_healths"),
                        readFileAsString("data2429_directions"),
                        List.of(readIntegerArray("data2429_expected"))
                )

        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int[] positions, int[] healths, String directions, List<Integer> expected) {
        Assertions.assertEquals(expected, new Solution().survivedRobotsHealths(positions, healths, directions));
    }

}