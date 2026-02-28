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
    
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode[] nodes = new ListNode[50000];

        int length = 0;
        ListNode node = head;
        while (node != null) {
            nodes[length] = node;
            node = node.next;
            length++;
        }

        node = head;

        int left = 1;
        int right = length - 1;
        boolean isLeft = false;
        while (left <= right) {
            if (isLeft) {
                node.next = nodes[left];
                left++;
            } else {
                node.next = nodes[right];
                right--;
            }
            isLeft = !isLeft;
            node = node.next;
        }

        node.next = null;

    }

}