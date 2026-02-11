package java_problems.hard.p3721;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.stream.Stream;

@DisplayName("3721. Longest Balanced Subarray II")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 2}, 3),
                Arguments.of(new int[]{1, 2, 3, 2, 4}, 5),
                Arguments.of(new int[]{2, 5, 4, 3}, 4),
                Arguments.of(new int[]{3, 2, 2, 5, 4}, 5),
                Arguments.of(new int[]{1, 2, 3, 2}, 3),
                Arguments.of(new int[]{27, 17, 46, 11, 46}, 3),
                Arguments.of(new int[]{25, 25, 14, 31, 21}, 3),
                Arguments.of(getRandomNums(1, 10, 10), -1),
                Arguments.of(getRandomNums(1, 100, 100), -1),
                Arguments.of(getRandomNums(1, 1000, 1000), -1),
                Arguments.of(getRandomNums(1, 10000, 10000), -1),
                Arguments.of(getRandomNums(1, 100000, 100000), -1)
        );
    }

    private static int[] getRandomNums(long seed, int length, int bound) {
        Random random = new Random(seed);
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) nums[i] = random.nextInt(bound);
        return nums;
    }

    private static int[] getRandomNums(int length, int bound) {
        return getRandomNums(new Random().nextLong(Long.MAX_VALUE), length, bound);
    }

    private static int[] getRandomNums(int length) {
        return getRandomNums(length, length);
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int[] nums, int expected) {
        Solution solution = new Solution();
        if (expected == -1) return;
        Assertions.assertEquals(expected, solution.longestBalanced(nums));
    }


    static Stream<Arguments> getLargeArrayProvider(String first) throws IOException {
        String content = Files.readString(Paths.get(first)).trim();
        String[] parts = content.split(",");

        int[] array = new int[parts.length - 1];
        for (int i = 0; i < parts.length - 1; i++) {
            array[i] = Integer.parseInt(parts[i].trim());
        }
        long expected = Long.parseLong(parts[parts.length - 1].trim());
        return Stream.of(Arguments.of(array, expected));
    }

    static Stream<Arguments> largeArrayProvider983() throws IOException {
        return getLargeArrayProvider("test/java_problems/hard/p3721/data983.csv");
    }

    @ParameterizedTest
    @MethodSource("largeArrayProvider983")
    void solutionTest983(int[] nums, long expected) {
        Solution solution = new Solution();
        Assertions.assertEquals(expected, solution.longestBalanced(nums));
    }

    static Stream<Arguments> largeArrayProvider987() throws IOException {
        return getLargeArrayProvider("test/java_problems/hard/p3721/data987.csv");
    }

    @ParameterizedTest
    @MethodSource("largeArrayProvider987")
    void solutionTest987(int[] nums, long expected) {
        Solution solution = new Solution();
        Assertions.assertEquals(expected, solution.longestBalanced(nums));
    }

    static Stream<Arguments> largeArrayProvider991() throws IOException {
        return getLargeArrayProvider("test/java_problems/hard/p3721/data991.csv");
    }

    @ParameterizedTest
    @MethodSource("largeArrayProvider991")
    void solutionTest991(int[] nums, long expected) {
        Solution solution = new Solution();
        Assertions.assertEquals(expected, solution.longestBalanced(nums));
    }

    static Stream<Arguments> largeArrayProvider993() throws IOException {
        return getLargeArrayProvider("test/java_problems/hard/p3721/data993.csv");
    }

    @ParameterizedTest
    @MethodSource("largeArrayProvider993")
    void solutionTest993(int[] nums, long expected) {
        Solution solution = new Solution();
        Assertions.assertEquals(expected, solution.longestBalanced(nums));
    }

    static Stream<Arguments> largeArrayProvider995() throws IOException {
        return getLargeArrayProvider("test/java_problems/hard/p3721/data995.csv");
    }

    @ParameterizedTest
    @MethodSource("largeArrayProvider995")
    void solutionTest995(int[] nums, long expected) {
        Solution solution = new Solution();
        Assertions.assertEquals(expected, solution.longestBalanced(nums));
    }

}