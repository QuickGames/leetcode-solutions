/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
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