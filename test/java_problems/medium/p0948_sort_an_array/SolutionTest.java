package java_problems.medium.p0948_sort_an_array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

@DisplayName("912. Sort an Array")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of((Object) new int[]{5, 2, 3, 1}),
                Arguments.of((Object) new int[]{5, 1, 1, 2, 0, 0}),
                Arguments.of((Object) new int[]{1}),
                Arguments.of(getRandomArray(10)),
                Arguments.of(getRandomArray(100, 10)),
                Arguments.of(getRandomArray(200)),
                Arguments.of(getRandomArray(1000)),
                Arguments.of(getRandomArray(10000)),
                Arguments.of(getRandomArray(100000, 1000)),
                Arguments.of(getRandomArray(1000000, 1000)),
                Arguments.of(getRandomArray(50000, 100000))
        );
    }

    private static Object getRandomArray(int length, int bound) {
        int[] nums = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            nums[i] = random.nextInt(bound);
        }
        return nums;
    }

    private static Object getRandomArray(int length) {
        return getRandomArray(length, length);
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int[] nums) {

        Solution solution = new Solution();
        int[] sourceNums = Arrays.copyOf(nums, nums.length);
        int[] result = solution.sortArray(nums);

        Assertions.assertNotNull(result, "Result array is null");

        Assertions.assertAll(
                () -> Assertions.assertEquals(sourceNums.length, result.length,
                        "Arrays lengths are not equals"),
                () -> {
                    long sourceSum = 0;
                    for (int n : sourceNums) sourceSum += n;
                    long sortedSum = 0;
                    for (int n : result) sortedSum += n;
                    Assertions.assertEquals(sourceSum, sortedSum, "Arrays sums are not equals");
                },
                () -> {
                    for (int i = 0; i < result.length - 1; i++) {
                        int c = result[i];
                        int n = result[i + 1];
                        if (c > n) {
                            Assertions.fail("Array is not sorted");
                            break;
                        }
                    }
                }
        );

        Arrays.sort(sourceNums);
        Assertions.assertArrayEquals(result, sourceNums, "Arrays elements are not equals");

    }

}