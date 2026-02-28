package java_problems.medium.p0002_add_two_numbers;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 2
 * Title: Add Two Numbers
 * Language: Java
 * Topic: Principal, Linked List, Math, Recursion
 */
class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int add) {
        if (add == 0 && l1 == null && l2 == null) return null;
        ListNode result = new ListNode((l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + add);
        add = 0;
        if (10 <= result.val) {
            result.val -= 10;
            add = 1;
        }
        result.next = addTwoNumbers((l1 == null ? null : l1.next), (l2 == null ? null : l2.next), add);
        return result;
    }

}
