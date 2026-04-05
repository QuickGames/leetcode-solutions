package java_problems.medium.p2336;

import java_problems.SolutionTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("2336. Smallest Number in Infinite Set")
class SolutionTest extends SolutionTestBase {

    static Stream<Arguments> provideData() {
        return Stream.of(

                Arguments.of(
                        new String[]{"SmallestInfiniteSet", "addBack", "popSmallest", "popSmallest", "popSmallest", "addBack", "popSmallest", "popSmallest", "popSmallest"},
                        new Integer[][]{{}, {2}, {}, {}, {}, {1}, {}, {}, {}},
                        new Integer[]{null, null, 1, 2, 3, null, 1, 4, 5}
                ),

                Arguments.of(
                        new String[]{"SmallestInfiniteSet", "popSmallest", "addBack", "addBack", "popSmallest", "addBack", "popSmallest", "popSmallest", "popSmallest"},
                        new Integer[][]{{}, {}, {1}, {1}, {}, {1}, {}, {}, {}},
                        new Integer[]{null, 1, null, null, 1, null, 1, 2, 3}
                )

        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(String[] commands, Integer[][] params, Integer[] expected) {
        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
        for (int i = 1; i < commands.length; i++) {
            if (commands[i].equals("addBack")) {
                smallestInfiniteSet.addBack(params[i][0]);
                System.out.println("addBack: " + params[i][0]);
            } else if (commands[i].equals("popSmallest")) {
                int actual = smallestInfiniteSet.popSmallest();
                System.out.println("popSmallest: " + actual + " : " + expected[i]);
                Assertions.assertEquals(expected[i], actual);
            }
        }
    }

}