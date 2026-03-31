package java_problems.medium.p1268;

import java_problems.SolutionTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@DisplayName("1268. Search Suggestions System")
class SolutionTest extends SolutionTestBase {

    static Stream<Arguments> provideData() throws IOException {
        return Stream.of(

                Arguments.of(
                        new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"},
                        "mouse",
                        List.of(
                                List.of("mobile", "moneypot", "monitor"),
                                List.of("mobile", "moneypot", "monitor"),
                                List.of("mouse", "mousepad"),
                                List.of("mouse", "mousepad"),
                                List.of("mouse", "mousepad")
                        )
                ),
                Arguments.of(
                        new String[]{"havana"},
                        "havana",
                        List.of(
                                List.of("havana"), List.of("havana"), List.of("havana"),
                                List.of("havana"), List.of("havana"), List.of("havana")
                        )
                ),

                Arguments.of(readStringArray("data10_products"),
                        "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchviotvdticwxwcliylrpvrokbcguhnfvpd",
                        Arrays.stream(readStringGrid("data10_expected")).map(Arrays::asList).toList()
                )

        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(String[] products, String searchWord, List<List<String>> expected) {
        Assertions.assertEquals(expected, new Solution().suggestedProducts(products, searchWord));
    }

}