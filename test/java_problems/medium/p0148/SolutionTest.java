package java_problems.medium.p0148;

import java_problems.SolutionTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("148. Sort List")
class SolutionTest extends SolutionTestBase {

    static Stream<Arguments> provideData() {

        int[] nodesVals28 = new int[50000];
        for (int i = 0; i < nodesVals28.length; i++) nodesVals28[i] = 50000 - i;

        int[] expected28 = new int[50000];
        for (int i = 0; i < expected28.length; i++) expected28[i] = i + 1;

        int[] nodesVals29 = new int[50000];
        nodesVals29[0] = 50000;
        for (int i = 1; i < nodesVals29.length; i++) nodesVals29[i] = i;

        int[] expected29 = new int[50000];
        for (int i = 0; i < expected29.length; i++) expected29[i] = i + 1;

        return Stream.of(

                Arguments.of(createList(4, 2, 1, 3), createList(1, 2, 3, 4)),
                Arguments.of(createList(-1, 5, 3, 4, 0), createList(-1, 0, 3, 4, 5)),
                Arguments.of(null, null),

                Arguments.of(createList(nodesVals28), createList(expected28)),
                Arguments.of(createList(nodesVals29), createList(expected29))

        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(ListNode head, ListNode expected) {
        ListNode actual = new Solution().sortList(head);
        assertLinkedListEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest3(ListNode head, ListNode expected) {
        ListNode actual = new Solution().sortList3(head);
        assertLinkedListEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest2(ListNode head, ListNode expected) {
        ListNode actual = new Solution().sortList2(head);
        assertLinkedListEquals(expected, actual);
    }

    private static ListNode createList(int... values) {
        if (values.length == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int v : values) {
            curr.next = new ListNode(v);
            curr = curr.next;
        }
        return dummy.next;
    }

    private void assertLinkedListEquals(ListNode expected, ListNode actual) {
        while (expected != null && actual != null) {
            Assertions.assertEquals(expected.val, actual.val);
            expected = expected.next;
            actual = actual.next;
        }
        Assertions.assertNull(expected);
        Assertions.assertNull(actual);
    }

}