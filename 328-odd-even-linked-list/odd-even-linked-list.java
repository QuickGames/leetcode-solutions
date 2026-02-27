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
    
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;

        ListNode node = head;
        if (node.next == null) return head;
        node = node.next;
        ListNode rightStart = node;
        ListNode right = rightStart;
        if (node.next == null) return head;
        node = node.next;
        ListNode left = node;
        head.next = left;
        node = node.next;

        boolean isLeft = false;
        while (node != null) {
            if (isLeft) {
                left.next = node;
                left = left.next;
            } else {
                right.next = node;
                right = right.next;
            }
            isLeft = !isLeft;
            node = node.next;
        }

        left.next = rightStart;
        right.next = null;
        return head;
    }

}