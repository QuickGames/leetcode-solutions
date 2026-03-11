package java_problems.medium.p2107_find_unique_binary_string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

@DisplayName("1980. Find Unique Binary String")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                // Ex 1: Length 2, "11" is missing
                Arguments.of(new String[]{"01", "10"}, "11"),
                // Ex 2: Length 2, "10" or "11" is missing
                Arguments.of(new String[]{"00", "01"}, "11"),
                // Ex 3: Length 3, "101" is missing
                Arguments.of(new String[]{"111", "011", "001"}, "101"),
                Arguments.of(new String[]{"1"}, "0")
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(String[] nums, String expected) {
        String actual = new Solution().findDifferentBinaryString(nums);

        Assertions.assertEquals(nums[0].length(), actual.length());

        Set<String> set = new HashSet<>(Arrays.asList(nums));
        Assertions.assertFalse(set.contains(actual));
    }

}