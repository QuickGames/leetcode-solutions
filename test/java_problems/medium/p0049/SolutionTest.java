package java_problems.medium.p0049;

import java_problems.SolutionTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@DisplayName("49. Group Anagrams")
class SolutionTest extends SolutionTestBase {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"},
                        new ArrayList<>(List.of(
                                new ArrayList<>(List.of("bat")),
                                new ArrayList<>(List.of("nat", "tan")),
                                new ArrayList<>(List.of("ate", "eat", "tea"))
                        ))
                ),
                Arguments.of(new String[]{""},
                        new ArrayList<>(List.of(new ArrayList<>(List.of(""))))),
                Arguments.of(new String[]{"a"},
                        new ArrayList<>(List.of(new ArrayList<>(List.of("a")))))
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(String[] strs, List<List<String>> expected) {
        List<List<String>> actual = new Solution().groupAnagrams(strs);

        actual.forEach(Collections::sort);
        expected.forEach(Collections::sort);

        actual.sort(Comparator.comparing(List::getFirst));
        expected.sort(Comparator.comparing(List::getFirst));

        Assertions.assertEquals(expected, actual);
    }

}