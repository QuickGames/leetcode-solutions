package java_problems.hard.p1622;

import java_problems.SolutionTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

@DisplayName("2104. Sum of Subarray Ranges")
class SolutionTest extends SolutionTestBase {

    static Stream<Arguments> provideData() throws IOException {
        return Stream.of(
                Arguments.of(
                        new String[]{"Fancy", "append", "addAll", "append", "multAll", "getIndex", "addAll", "append", "multAll", "getIndex", "getIndex", "getIndex"},
                        new Integer[][]{{}, {2}, {3}, {7}, {2}, {0}, {3}, {10}, {2}, {0}, {1}, {2}},
                        new Integer[]{null, null, null, null, null, 10, null, null, null, 26, 34, 20}
                ),
                Arguments.of(
                        new String[]{"Fancy", "append", "append", "getIndex", "append", "getIndex", "addAll", "append", "getIndex", "getIndex", "append", "append", "getIndex", "append", "getIndex", "append", "getIndex", "append", "getIndex", "multAll", "addAll", "getIndex", "append", "addAll", "getIndex", "multAll", "getIndex", "multAll", "addAll", "addAll", "append", "multAll", "append", "append", "append", "multAll", "getIndex", "multAll", "multAll", "multAll", "getIndex", "addAll", "append", "multAll", "addAll", "addAll", "multAll", "addAll", "addAll", "append", "append", "getIndex"},
                        new Integer[][]{{}, {12}, {8}, {1}, {12}, {0}, {12}, {8}, {2}, {2}, {4}, {13}, {4}, {12}, {6}, {11}, {1}, {10}, {2}, {3}, {1}, {6}, {14}, {5}, {6}, {12}, {3}, {12}, {15}, {6}, {7}, {8}, {13}, {15}, {15}, {10}, {9}, {12}, {12}, {9}, {9}, {9}, {9}, {4}, {8}, {11}, {15}, {9}, {1}, {4}, {10}, {9}},
                        new Integer[]{null, null, null, 8, null, 12, null, null, 24, 24, null, null, 4, null, 12, null, 20, null, 24, null, null, 37, null, null, 42, null, 360, null, null, null, null, null, null, null, null, null, 220560, null, null, null, 285845760, null, null, null, null, null, null, null, null, null, null, 150746316}
                ),
                Arguments.of(
                        readStringArray("data104_commands"),
                        readIntegerGrid("data104_params"),
                        readIntegerArray("data104_expected")
                ),
                Arguments.of(
                        readStringArray("data106_commands"),
                        readIntegerGrid("data106_params"),
                        readIntegerArray("data106_expected")
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(String[] commands, Integer[][] params, Integer[] expected) {
        Fancy fancy = new Fancy();
        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]) {
                case "Fancy" -> fancy = new Fancy();
                case "append" -> fancy.append(params[i][0]);
                case "addAll" -> fancy.addAll(params[i][0]);
                case "multAll" -> fancy.multAll(params[i][0]);
                case "getIndex" -> Assertions.assertEquals(expected[i], fancy.getIndex(params[i][0]));
            }
        }
    }

}