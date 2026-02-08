package java_problems.medium.p0649;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("649. Dota2 Senate")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of("RD", "Radiant"),
                Arguments.of("RDD", "Dire"),
                Arguments.of("DDRRR", "Dire"),
                Arguments.of("DRRDDR", "Dire"),
                Arguments.of("DRRDRDRDRDDRDRDR", "Radiant"),
                Arguments.of("DRRDRDRDRDDRDRDRD", "Dire"),
                Arguments.of("D", "Dire"),
                Arguments.of("R", "Radiant"),
                Arguments.of("DDD", "Dire"),
                Arguments.of("RRR", "Radiant")
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void constructTransformedArray(String senate, String expected) {
        Solution solution = new Solution();
        Assertions.assertEquals(expected, solution.predictPartyVictory(senate));
    }

}