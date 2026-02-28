package java_problems.medium.p0328_odd_even_linked_list;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 328
 * Title: Odd Even Linked List
 * Language: Java
 * Topic: Linked List
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
