package java_problems.easy.p0242;

import java_problems.SolutionTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("242. Valid Anagram")
class SolutionTest extends SolutionTestBase {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of("anagram", "nagaram", true),
                Arguments.of("rat", "car", false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest2(String s, String t, boolean expected) {
        Assertions.assertEquals(expected, new Solution().isAnagram(s, t));
    }

}