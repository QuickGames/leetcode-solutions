package java_problems.medium.p2906;

import java_problems.SolutionTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("2906. Construct Product Matrix")
class SolutionTest extends SolutionTestBase {

    static Stream<Arguments> provideData() {
        return Stream.of(

                Arguments.of(new int[][]{{1, 2}, {3, 4}}, new int[][]{{24, 12}, {8, 6}}),
                Arguments.of(new int[][]{{12345}, {2}, {1}}, new int[][]{{2}, {0}, {0}}),

                Arguments.of(new int[][]{{10, 20}, {18, 16}, {17, 14}, {16, 9}, {14, 6}, {16, 5}, {14, 8}, {20, 13}, {16, 10}, {14, 17}},
                        new int[][]{{345, 6345}, {7050, 4845}, {4560, 2010}, {4845, 1755}, {2010, 8805}, {4845, 690}, {2010, 9690}, {6345, 1215}, {4845, 345}, {2010, 4560}}),
                Arguments.of(new int[][]{{6, 4, 10}, {9, 5, 8}, {2, 10, 3}, {6, 10, 10}, {5, 8, 7}},
                        new int[][]{{8490, 390, 2625}, {1545, 5250, 195}, {780, 2625, 4635}, {8490, 2625, 2625}, {5250, 195, 3750}}),
                Arguments.of(new int[][]{{31, 29, 9, 19}, {32, 24, 9, 11}, {11, 11, 7, 18}, {31, 21, 34, 29}, {34, 12, 29, 14}, {26, 11, 6, 33}, {3, 17, 2, 28}, {30, 11, 32, 26}, {8, 8, 10, 33}, {11, 20, 10, 32}, {11, 29, 9, 33}, {12, 20, 32, 22}, {21, 10, 22, 19}, {4, 32, 3, 11}, {30, 15, 31, 29}, {2, 13, 18, 23}, {16, 6, 26, 23}},
                        new int[][]{{585, 6585, 10245, 12000}, {7125, 5385, 10245, 7260}, {7260, 7260, 9645, 11295}, {585, 11445, 3075, 6585}, {3075, 10770, 6585, 10995}, {6870, 7260, 9195, 10650}, {6045, 6150, 2895, 11670}, {11715, 7260, 7125, 6870}, {3810, 3810, 10455, 10650}, {7260, 11400, 10455, 7125}, {7260, 6585, 10245, 10650}, {10770, 11400, 7125, 3630}, {11445, 10455, 3630, 12000}, {7620, 7125, 6045, 7260}, {11715, 11085, 585, 6585}, {2895, 1395, 11295, 12060}, {1905, 9195, 6870, 12060}}),
                Arguments.of(new int[][]{{872643377, 791741352, 678781611}},
                        new int[][]{{2847, 8502, 9969}})

        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int[][] grid, int[][] expected) {
        Assertions.assertArrayEquals(expected, new Solution().constructProductMatrix(grid));
    }

}