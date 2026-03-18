package java_problems.hard.p0068;

import java_problems.SolutionTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

@DisplayName("68. Text Justification")
class SolutionTest extends SolutionTestBase {

    static Stream<Arguments> provideData() {
        return Stream.of(Arguments.of(
                        new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16,
                        List.of("This    is    an",
                                "example  of text",
                                "justification.  ")
                ),
                Arguments.of(
                        new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16,
                        List.of("What   must   be",
                                "acknowledgment  ",
                                "shall be        ")
                ),
                Arguments.of(
                        new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20,
                        List.of("Science  is  what we",
                                "understand      well",
                                "enough to explain to",
                                "a  computer.  Art is",
                                "everything  else  we",
                                "do                  ")
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(String[] words, int maxWidth, List<String> expected) {
        Assertions.assertEquals(expected, new Solution().fullJustify(words, maxWidth));
    }

}