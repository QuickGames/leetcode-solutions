package java_problems.medium.p0200_number_of_islands;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

@DisplayName("200. Number of Islands")
class SolutionTest {

    static Stream<Arguments> provideData() throws IOException {
        return Stream.of(
                // Ex 1: Single island
                Arguments.of(new char[][]{
                        {'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}
                }, 1),
                // Ex 2: Three separate islands
                Arguments.of(new char[][]{
                        {'1', '1', '0', '0', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '1', '0', '0'},
                        {'0', '0', '0', '1', '1'}
                }, 3),
                Arguments.of(loadGrid("test/java_problems/medium/p0200/data48.csv"), 22512)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(char[][] grid, int expected) {
        Assertions.assertEquals(expected, new Solution().numIslands(grid));
    }

    static char[][] loadGrid(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        char[][] grid = new char[lines.size()][];
        for (int i = 0; i < lines.size(); i++) {
            String cleaned = lines.get(i).replaceAll("[^01]", "");
            grid[i] = cleaned.toCharArray();
        }
        return grid;
    }

}