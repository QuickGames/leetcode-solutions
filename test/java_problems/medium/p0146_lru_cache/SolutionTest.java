package java_problems.medium.p0146_lru_cache;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("146. LRU Cache")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(
                        new String[]{"LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"},
                        new Integer[][]{{2}, {1, 1}, {2, 2}, {1}, {3, 3}, {2}, {4, 4}, {1}, {3}, {4}},
                        new Integer[]{null, null, null, 1, null, -1, null, -1, 3, 4}
                ),
                Arguments.of(
                        new String[]{"LRUCache", "get", "put", "get", "put", "put", "get", "get"},
                        new Integer[][]{{2}, {2}, {2, 6}, {1}, {1, 5}, {1, 2}, {1}, {2}},
                        new Integer[]{null, -1, null, -1, null, null, 2, 6}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(String[] commands, Integer[][] params, Integer[] expected) {
        LRUCache lruCache = new LRUCache(params[0][0]);
        for (int i = 1; i < commands.length; i++) {
            if (commands[i].equals("put")) {
                lruCache.put(params[i][0], params[i][1]);
            } else if (commands[i].equals("get")) {
                Assertions.assertEquals(expected[i], lruCache.get(params[i][0]));
            }
        }
    }

}