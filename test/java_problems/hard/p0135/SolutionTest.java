package java_problems.hard.p0135;

import java_problems.SolutionTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("135. Candy")
class SolutionTest extends SolutionTestBase {

    static Stream<Arguments> provideData() {
        return Stream.of(

                Arguments.of(new int[]{1,2,3}, 6),
                Arguments.of(new int[]{3,2,1}, 6),

                Arguments.of(new int[]{1, 0, 2}, 5),
                Arguments.of(new int[]{1, 2, 2}, 4),

                Arguments.of(new int[]{1,3,4,5,2}, 11),
                Arguments.of(new int[]{0,1,2,5,3,2,7}, 15)

        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(int[] ratings, int expected) {
        Assertions.assertEquals(expected, new Solution().candy(ratings));
    }

}