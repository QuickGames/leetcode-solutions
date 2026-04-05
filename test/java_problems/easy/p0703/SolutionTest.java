package java_problems.easy.p0703;

import java_problems.SolutionTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("703. Kth Largest Element in a Stream")
class SolutionTest extends SolutionTestBase {

    static Stream<Arguments> provideData() {
        return Stream.of(

                Arguments.of(
                        new String[]{"KthLargest", "add", "add", "add", "add", "add"},
                        new int[][]{{3}, {4, 5, 8, 2}},
                        new Integer[]{null, 3, 5, 10, 9, 4},
                        new Integer[]{null, 4, 5, 5, 8, 8}
                ),
                Arguments.of(
                        new String[]{"KthLargest", "add", "add", "add", "add"},
                        new int[][]{{4}, {7, 7, 7, 7, 8, 3}},
                        new Integer[]{null, 2, 10, 9, 9},
                        new Integer[]{null, 7, 7, 7, 8}
                ),

                Arguments.of(
                        new String[]{"KthLargest", "add", "add", "add", "add", "add"},
                        new int[][]{{1}, {}},
                        new Integer[]{null, -3,-2,-4,0,4},
                        new Integer[]{null,-3,-2,-2,0,4}
                )

        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(String[] commands, int[][] constructorParams, Integer[] params, Integer[] expected) {
        KthLargest kthLargest = new KthLargest(constructorParams[0][0], constructorParams[1]);
        for (int i = 1; i < commands.length; i++) {
            if (commands[i].equals("add")) {
                Assertions.assertEquals(expected[i], kthLargest.add(params[i]));
            }
        }
    }

}