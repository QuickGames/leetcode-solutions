package java_problems.medium.p0017;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

@DisplayName("17. Letter Combinations of a Phone Number")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of("23", List.of("ad","ae","af","bd","be","bf","cd","ce","cf")),
                Arguments.of("2", List.of("a","b","c"))
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(String digits, List<String> expected) {
        Assertions.assertEquals(expected, new Solution().letterCombinations(digits));
    }

}