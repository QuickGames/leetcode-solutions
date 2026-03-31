package java_problems.hard.p2573;

import java_problems.SolutionTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

@DisplayName("2573. Find the String with LCP")
class SolutionTest extends SolutionTestBase {

    static Stream<Arguments> provideData() throws IOException {
        return Stream.of(

                Arguments.of(new int[][]{{3, 0, 1}, {0, 2, 0}, {1, 0, 1}}, "aba"),
                Arguments.of(new int[][]{{3, 2, 1}, {2, 2, 0}, {1, 0, 1}}, ""),
                Arguments.of(new int[][]{{4, 0, 1, 0}, {0, 3, 0, 2}, {1, 0, 2, 0}, {0, 2, 0, 1}}, ""),
                Arguments.of(new int[][]{{3, 1, 0}, {1, 2, 1}, {0, 1, 1}}, ""),
                Arguments.of(new int[][]{{6, 0, 0, 3, 0, 0}, {0, 5, 0, 0, 2, 0}, {0, 0, 4, 0, 0, 1}, {3, 0, 0, 3, 0, 0}, {0, 2, 0, 0, 2, 0}, {0, 0, 1, 0, 0, 1}}, "abcabc"),
                Arguments.of(new int[][]{{6, 0, 4, 0, 2, 0}, {0, 5, 0, 3, 0, 1}, {4, 0, 4, 0, 2, 0}, {0, 3, 0, 3, 0, 1}, {2, 0, 2, 0, 2, 0}, {0, 1, 0, 1, 0, 1}}, "ababab"),
                Arguments.of(new int[][]{{5, 0, 0, 2, 0}, {0, 4, 0, 0, 1}, {0, 0, 3, 0, 0}, {2, 0, 0, 2, 0}, {0, 1, 0, 0, 1}}, "abcab"),
                Arguments.of(new int[][]{{7, 0, 2, 0, 0, 2, 0}, {0, 6, 0, 1, 0, 0, 1}, {2, 0, 5, 0, 0, 2, 0}, {0, 1, 0, 4, 0, 0, 1}, {0, 0, 0, 0, 3, 0, 0}, {2, 0, 2, 0, 0, 2, 0}, {0, 1, 0, 1, 0, 0, 1}}, "ababcab"),

                Arguments.of(new int[][]{{4, 0, 2, 0}, {0, 3, 0, 1}, {2, 0, 2, 0}, {0, 1, 0, 1}}, "abab"),
                Arguments.of(new int[][]{{4, 3, 2, 1}, {3, 3, 2, 1}, {2, 2, 2, 1}, {1, 1, 1, 1}}, "aaaa"),
                Arguments.of(new int[][]{{4, 3, 2, 1}, {3, 3, 2, 1}, {2, 2, 2, 1}, {1, 1, 1, 3}}, ""),

                Arguments.of(new int[][]{{27, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 26, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 21, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 18, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 17, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}}, ""),
                Arguments.of(readIntGrid("data53_lcp"), "abcdaefghijklkgbmknopqrmpmbgdsfiltqurvjewrmgoluurmumxfyqqibundkodhoajjzfiemqyegtodpnrljuyjehxbrrtojfxanrgpkgqjxqbuasahjmmejwwfvmqmgmnuisevwqhyhsjiopvhjhwqehuierworaxkymqjpcdkzsflbsxbfkqtuwjkiphhewiufuhkdslxccwnbwtlqwsabrtukfgyeygqfetqcogemsewyygcojldghqczpnbdzuycaptiaggycohjhtyscaxlboeuqekorrbzulvvextbjkgolpejrxnppdzhxljiqqstzaqknbldlvmvufxfyeyiygjdmrbfrmckhtco")

        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int[][] lcp, String expected) {
        Assertions.assertEquals(expected, new Solution().findTheString(lcp));
    }

}