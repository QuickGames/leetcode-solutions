package java_problems.medium.p0380_insert_delete_getrandom_o1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("380. Insert Delete GetRandom O(1)")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new String[]{"RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"},
                        new Integer[][]{{}, {1}, {2}, {2}, {}, {1}, {2}, {}},
                        new Object[]{null, true, false, true, 2, true, false, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(String[] commands, Integer[][] args, Object[] expected) {
        RandomizedSet set = null;

        for (int i = 0; i < commands.length; i++) {
            String cmd = commands[i];
            Object exp = expected[i];
            Integer val = args[i].length > 0 ? args[i][0] : null;

            switch (cmd) {
                case "RandomizedSet" -> set = new RandomizedSet();
                case "insert" -> {
                    Assertions.assertNotNull(set);
                    Assertions.assertEquals(exp, set.insert(val));
                }
                case "remove" -> {
                    Assertions.assertNotNull(set);
                    Assertions.assertEquals(exp, set.remove(val));
                }
                case "getRandom" -> {
                    Assertions.assertNotNull(set);
                    if (exp != null) Assertions.assertTrue(-1 < set.getRandom(), "getRandom() is -1");
                }
            }
        }
    }

}