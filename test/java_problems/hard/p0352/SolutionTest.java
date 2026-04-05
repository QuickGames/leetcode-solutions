package java_problems.hard.p0352;

import java_problems.SolutionTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

@DisplayName("352. Data Stream as Disjoint Intervals")
class SolutionTest extends SolutionTestBase {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(
                        new String[]{"SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"},
                        new Integer[][]{{}, {1}, {}, {3}, {}, {7}, {}, {2}, {}, {6}, {}},
                        new Integer[][][]{null, null, {{1, 1}}, null, {{1, 1}, {3, 3}}, null, {{1, 1}, {3, 3}, {7, 7}}, null, {{1, 3}, {7, 7}}, null, {{1, 3}, {6, 7}}}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(String[] commands, Integer[][] params, Integer[][][] expected) {
        SummaryRanges summaryRanges = new SummaryRanges();
        for (int i = 1; i < commands.length; i++) {
            switch (commands[i]) {
                case "addNum" -> summaryRanges.addNum(params[i][0]);
                case "getIntervals" -> {
                    int[][] result = summaryRanges.getIntervals();
                    Integer[][] resultInteger = Arrays.stream(result)
                            .map(row -> Arrays.stream(row).boxed().toArray(Integer[]::new))
                            .toArray(Integer[][]::new);
                    Assertions.assertArrayEquals(expected[i], resultInteger);
                }
            }
        }
    }

}