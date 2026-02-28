package java_problems.medium.p0061_rotate_list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("61. Rotate List")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                // [1,2,3,4,5], k = 2 -> [4,5,1,2,3]
                Arguments.of(
                        createListNode(new int[]{1, 2, 3, 4, 5}),
                        2,
                        createListNode(new int[]{4, 5, 1, 2, 3})
                ),
                // [0,1,2], k = 4 -> (4 % 3 = 1) -> [2,0,1]
                Arguments.of(
                        createListNode(new int[]{0, 1, 2}),
                        4,
                        createListNode(new int[]{2, 0, 1})
                ),
                Arguments.of(
                        createListNode(new int[]{}),
                        1,
                        createListNode(new int[]{})
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(ListNode head, int k, ListNode expected) {
        Solution sol = new Solution();
        ListNode actual = sol.rotateRight(head, k);

        assertLinkedListEquals(expected, actual);
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