package java_problems.medium.p0937_online_stock_span;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("901. Online Stock Span")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(
                        new String[]{"StockSpanner", "next", "next", "next", "next", "next", "next", "next"},
                        new Integer[][]{{}, {100}, {80}, {60}, {70}, {60}, {75}, {85}},
                        new Integer[]{null, 1, 1, 1, 2, 1, 4, 6}
                ),
                Arguments.of(
                        new String[]{"StockSpanner", "next", "next", "next", "next", "next"},
                        new Integer[][]{{}, {31}, {41}, {48}, {59}, {79}},
                        new Integer[]{null, 1, 2, 3, 4, 5}
                ),
                Arguments.of(
                        new String[]{"StockSpanner", "next", "next", "next", "next", "next"},
                        new Integer[][]{{}, {29}, {91}, {62}, {76}, {51}},
                        new Integer[]{null, 1, 2, 1, 2, 1}
                ), Arguments.of(
                        new String[]{"StockSpanner", "next", "next", "next", "next", "next", "next", "next", "next", "next", "next"},
                        new Integer[][]{{}, {28}, {14}, {28}, {35}, {46}, {53}, {66}, {80}, {87}, {88}},
                        new Integer[]{null, 1, 1, 3, 4, 5, 6, 7, 8, 9, 10}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(String[] commands, Integer[][] inputs, Integer[] expected) {
        StockSpanner spanner = null;

        for (int i = 0; i < commands.length; i++) {
            if ("StockSpanner".equals(commands[i])) {
                spanner = new StockSpanner();
                Assertions.assertNull(expected[i], "Output for constructor should be null");
            } else if ("next".equals(commands[i])) {
                Assertions.assertNotNull(spanner, "Spanner not initialized!");
                int result = spanner.next(inputs[i][0]);
                Assertions.assertEquals(expected[i], result, "Mismatch at step " + i);
            }
        }

    }

}