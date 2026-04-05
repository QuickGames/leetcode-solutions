package java_problems.hard.p0381;

import java_problems.SolutionTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

@DisplayName("381. Insert Delete GetRandom O(1) - Duplicates allowed")
class SolutionTest extends SolutionTestBase {

    static Stream<Arguments> provideData() throws IOException {
        return Stream.of(
                Arguments.of(
                        new String[]{"RandomizedCollection", "insert", "insert", "insert", "getRandom", "remove", "getRandom"},
                        new Integer[][]{{}, {1}, {1}, {2}, {}, {1}, {}},
                        new Object[]{null, true, false, true, 2, true, 1}
                ),
                Arguments.of(
                        new String[]{"RandomizedCollection", "insert", "insert", "remove", "insert", "remove", "getRandom"},
                        new Integer[][]{{}, {0}, {1}, {0}, {2}, {1}, {}},
                        new Object[]{null, true, true, true, true, true, 2}
                ), Arguments.of(
                        readStringArray("data29_commands"),
                        readIntegerGrid("data29_params"),
                        readObjectArray("data29_expected")
                ),
                Arguments.of(
                        readStringArray("data30_commands"),
                        readIntegerGrid("data30_params"),
                        readObjectArray("data30_expected")
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(String[] commands, Integer[][] params, Object[] expected) {
        RandomizedCollection rc = new RandomizedCollection();
        HashMap<Integer, Integer> randoms = new HashMap<>();
        HashMap<Integer, Integer> rcRandoms = new HashMap<>();
        List<Integer> paramsValues = new ArrayList<>();
        for (int i = 1; i < commands.length; i++) {
            switch (commands[i]) {
                case "insert" -> {
                    paramsValues.add(params[i][0]);
                    Assertions.assertEquals(expected[i], rc.insert(params[i][0]));
                }
                case "remove" -> Assertions.assertEquals(expected[i], rc.remove(params[i][0]));
                case "getRandom" -> {
                    int rcValue = rc.getRandom();
                    Assertions.assertNotEquals(-1, rcValue);
                    Assertions.assertTrue(paramsValues.contains(rcValue));
                    randoms.putIfAbsent((Integer) expected[i], 0);
                    randoms.computeIfPresent((Integer) expected[i], (key, value) -> value + 1);
                    rcRandoms.putIfAbsent(rcValue, 0);
                    rcRandoms.computeIfPresent(rcValue, (key, value) -> value + 1);
                }
            }
        }
    }

}