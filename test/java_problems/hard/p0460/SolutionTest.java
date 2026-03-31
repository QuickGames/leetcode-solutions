package java_problems.hard.p0460;

import java_problems.SolutionTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

@DisplayName("460. LFU Cache")
class SolutionTest extends SolutionTestBase {

    static Stream<Arguments> provideData() throws IOException {
        return Stream.of(

                Arguments.of(
                        new String[]{"LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"},
                        new Integer[][]{{2}, {1, 1}, {2, 2}, {1}, {3, 3}, {2}, {3}, {4, 4}, {1}, {3}, {4}},
                        new Integer[]{null, null, null, 1, null, -1, 3, null, -1, 3, 4}
                ),

                Arguments.of(
                        new String[]{"LFUCache", "put", "put", "get", "put", "put", "get"},
                        new Integer[][]{{2}, {2, 1}, {2, 2}, {2}, {1, 1}, {4, 1}, {2}},
                        new Integer[]{null, null, null, 2, null, null, 2}
                ),

                Arguments.of(
                        readStringArray("data22_commands"),
                        readIntegerGrid("data22_params"),
                        readIntegerArray("data22_expected")
                )

        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(String[] commands, Integer[][] params, Integer[] expected) {
        LFUCache lfuCache = new LFUCache(params[0][0]);
        for (int i = 1; i < commands.length; i++) {
            if (commands[i].equals("put")) {
                lfuCache.put(params[i][0], params[i][1]);
            } else if (commands[i].equals("get")) {
                Assertions.assertEquals(expected[i], lfuCache.get(params[i][0]));
            }
        }
    }

}