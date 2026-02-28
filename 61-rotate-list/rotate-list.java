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
    
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        int length = 0;
        ListNode[] nodes = new ListNode[500];
        ListNode node = head;
        while (node != null) {
            nodes[length] = node;
            length++;
            node = node.next;
        }

        int ost = k % length;
        if (ost == 0) return head;

        int index = length - ost;
        nodes[length - 1].next = head;
        if (index - 1 < 0) nodes[length - 1].next = null;
        else nodes[index - 1].next = null;
        return nodes[index];
    }

}