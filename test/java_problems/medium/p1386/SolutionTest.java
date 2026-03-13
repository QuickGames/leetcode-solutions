package java_problems.medium.p1386;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@DisplayName("1386. Cinema Seat Allocation")
class SolutionTest {

    static Stream<Arguments> provideData() throws IOException {
        return Stream.of(
                Arguments.of(1000000000, new int[][]{{1, 1}}, 2000000000),
                Arguments.of(3, new int[][]{{1, 2}, {1, 3}, {1, 8}, {2, 6}, {3, 1}, {3, 10}}, 4),
                Arguments.of(2, new int[][]{{2, 1}, {1, 8}, {2, 6}}, 2),
                Arguments.of(4, new int[][]{{4, 3}, {1, 4}, {4, 6}, {1, 7}}, 4),
                Arguments.of(1000000000, readPairs("test/java_problems/medium/p1386/data48"), 1999994439),
                Arguments.of(3, new int[][]{{2, 3}}, 5),
                Arguments.of(186, new int[][]{{121, 9}, {91, 8}, {178, 6}, {66, 7}, {66, 6}, {61, 8}, {151, 3}, {126, 6}, {175, 2}, {11, 1}, {36, 1}, {19, 6}, {184, 3}, {99, 6}, {9, 9}, {43, 8}, {73, 6}, {56, 6}, {112, 10}, {80, 8}, {179, 6}, {143, 9}, {80, 6}, {91, 2}, {83, 9}, {85, 2}, {139, 5}, {60, 6}, {164, 9}, {133, 10}, {165, 1}, {144, 8}, {121, 4}, {77, 1}, {116, 2}, {172, 4}, {42, 9}, {20, 4}, {97, 5}, {174, 5}, {38, 7}, {87, 3}, {37, 5}, {113, 10}, {85, 10}, {6, 2}, {104, 9}, {63, 5}, {102, 6}, {72, 8}, {177, 8}, {145, 4}, {88, 2}, {154, 3}, {63, 1}, {170, 6}, {113, 8}, {157, 8}, {15, 3}, {112, 8}, {91, 7}, {16, 9}, {126, 4}, {29, 4}, {49, 4}, {62, 3}, {142, 8}, {138, 8}, {169, 4}, {133, 5}, {153, 6}, {174, 9}, {36, 7}, {57, 8}, {158, 4}, {176, 8}, {57, 2}, {183, 3}, {32, 10}, {164, 6}, {69, 5}, {174, 1}, {104, 4}, {30, 9}, {7, 2}, {173, 8}, {166, 3}, {60, 8}, {22, 1}, {53, 4}, {21, 5}, {102, 10}, {53, 2}, {146, 10}, {53, 3}, {146, 2}, {185, 2}, {98, 8}, {76, 9}, {85, 5}}, 295)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int n, int[][] reservedSeats, int expected) {
        Assertions.assertEquals(expected, new Solution().maxNumberOfFamilies(n, reservedSeats));
    }

    static int[][] readPairs(String path) throws IOException {
        String content = Files.readString(Paths.get(path)).trim();
        String[] pairs = content.substring(2, content.length() - 2).split("],\\[");
        int[][] data = new int[pairs.length][2];

        for (int i = 0; i < pairs.length; i++) {
            String[] parts = pairs[i].split(",");
            data[i][0] = Integer.parseInt(parts[0]);
            data[i][1] = Integer.parseInt(parts[1]);
        }
        return data;
    }

}