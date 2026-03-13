package java_problems.hard.p0023;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("23. Merge k Sorted Lists")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(
                        new ListNode[]{createListNode(1, 4, 5), createListNode(1, 3, 4), createListNode(2, 6)},
                        createListNode(1, 1, 2, 3, 4, 4, 5, 6)
                ),
                Arguments.of(new ListNode[]{}, null),
                Arguments.of(new ListNode[]{null}, null)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(ListNode[] lists, ListNode expected) {
        ListNode actual = new Solution().mergeKLists(lists);
        assertLinkedListEquals(expected, actual);
    }

    private static ListNode createListNode(int... vals) {
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