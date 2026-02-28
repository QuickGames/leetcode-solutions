package java_problems.medium.p0328_odd_even_linked_list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("328. Odd Even Linked List")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(
                        createListNode(new int[]{}),
                        createListNode(new int[]{})
                ),
                Arguments.of(
                        createListNode(new int[]{0}),
                        createListNode(new int[]{0})
                ),
                Arguments.of(
                        createListNode(new int[]{0, 1}),
                        createListNode(new int[]{0, 1})
                ),
                Arguments.of(
                        createListNode(new int[]{0, 1, 2}),
                        createListNode(new int[]{0, 2, 1})
                ),
                // [1,2,3,4,5] -> [1,3,5, 2,4]
                Arguments.of(
                        createListNode(new int[]{1, 2, 3, 4, 5}),
                        createListNode(new int[]{1, 3, 5, 2, 4})
                ),
                // [2,1,3,5,6,4,7] -> [2,3,6,7, 1,5,4]
                Arguments.of(
                        createListNode(new int[]{2, 1, 3, 5, 6, 4, 7}),
                        createListNode(new int[]{2, 3, 6, 7, 1, 5, 4})
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void pairSumTest(ListNode head, ListNode expected) {
        Solution sol = new Solution();
        ListNode result = sol.oddEvenList(head);

        assertLinkedListEquals(expected, result);
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

    private void assertLinkedListEquals(ListNode expected, ListNode actual) {
        while (expected != null && actual != null) {
            Assertions.assertEquals(expected.val, actual.val, "Value mismatch");
            expected = expected.next;
            actual = actual.next;
        }
        Assertions.assertNull(expected, "Expected list is longer");
        Assertions.assertNull(actual, "Actual list is longer");
    }

}