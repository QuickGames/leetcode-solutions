package java_problems.medium.p0913_random_flip_matrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

@DisplayName("519. Random Flip Matrix")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(
                        new String[]{"Solution", "flip", "flip", "flip", "reset", "flip"},
                        3, 1
                ),
                Arguments.of(
                        new String[]{"Solution", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "reset", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "reset", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "reset", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip", "flip"},
                        500, 250
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(String[] commands, int m, int n) {
        Solution solution = null;
        HashMap<String, Integer> flips = new HashMap<>();
        for (int i = 0; i < commands.length; i++) {
            String cmd = commands[i];

            switch (cmd) {
                case "Solution" -> solution = new Solution(m, n);
                case "flip" -> {
                    int[] result = solution.flip();
                    Assertions.assertTrue(result[0] <= m, "Row index " + result[0] + " out of bounds for m=" + m);
                    Assertions.assertTrue(result[1] <= n, "Col index " + result[1] + " out of bounds for n=" + n);
                    String key = result[0] + "_" + result[1];
                    Integer def = flips.getOrDefault(key, -1);
                    System.out.print(Arrays.toString(result) + "; ");
                    Assertions.assertEquals(-1, def, "Duplicate point: " + key);
                    flips.put(key, 1);
                }
                case "reset" -> {
                    solution.reset();
                    System.out.println("reset" + "; ");
                    flips.clear();
                }
            }
        }
    }

}