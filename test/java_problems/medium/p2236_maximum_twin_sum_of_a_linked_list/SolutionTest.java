package java_problems.medium.p2236_maximum_twin_sum_of_a_linked_list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("2130. Maximum Twin Sum of a Linked List")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                // [5,4,2,1] -> (5+1), (4+2) -> max(6, 6) = 6
                Arguments.of(
                        createListNode(new int[]{5, 4, 2, 1}),
                        6
                ),
                // [4,2,2,3] -> (4+3), (2+2) -> max(7, 4) = 7
                Arguments.of(
                        createListNode(new int[]{4, 2, 2, 3}),
                        7
                ),
                // [1,100000] -> (1+100000) = 100001
                Arguments.of(
                        createListNode(new int[]{1, 100000}),
                        100001
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void pairSumTest(ListNode head, int expected) {
        Solution sol = new Solution();
        int actual = sol.pairSum(head);

        Assertions.assertEquals(expected, actual,
                String.format("Twin sum mismatch! Expected: %d, but got: %d", expected, actual));
    }

    private static ListNode createListNode(int[] vals) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int v : vals) {
            curr.next = new ListNode(v);
            curr = curr.next;
        }
        return dummy.next;
    }

}