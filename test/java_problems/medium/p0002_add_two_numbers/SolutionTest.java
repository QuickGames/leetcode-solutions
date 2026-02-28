package java_problems.medium.p0002_add_two_numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("2. Add Two Numbers")
class SolutionTest {
    static Stream<Arguments> provideData() {
        return Stream.of(
                // [2,4,3] + [5,6,4] = [7,0,8]
                Arguments.of(
                        createListNode(new int[]{2, 4, 3}),
                        createListNode(new int[]{5, 6, 4}),
                        createListNode(new int[]{7, 0, 8})
                ),
                // [0] + [0] = [0]
                Arguments.of(
                        createListNode(new int[]{0}),
                        createListNode(new int[]{0}),
                        createListNode(new int[]{0})
                ),
                // [9,9,9,9,9,9,9] + [9,9,9,9] = [8,9,9,9,0,0,0,1]
                Arguments.of(
                        createListNode(new int[]{9, 9, 9, 9, 9, 9, 9}),
                        createListNode(new int[]{9, 9, 9, 9}),
                        createListNode(new int[]{8, 9, 9, 9, 0, 0, 0, 1})
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void addTwoNumbersTest(ListNode l1, ListNode l2, ListNode expected) {
        Solution sol = new Solution();
        ListNode result = sol.addTwoNumbers(l1, l2);

        while (expected != null || result != null) {
            Assertions.assertNotNull(expected, "Result list is longer than expected");
            Assertions.assertNotNull(result, "Result list is shorter than expected");
            Assertions.assertEquals(expected.val, result.val, "Value mismatch");
            expected = expected.next;
            result = result.next;
        }
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