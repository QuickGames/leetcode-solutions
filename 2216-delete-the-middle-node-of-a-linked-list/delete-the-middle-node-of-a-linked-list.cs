/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    public ListNode DeleteMiddle(ListNode head) {
        if (head.next == null) return null;

        ListNode node = head;
        int count = 0;
        while (node != null) {
            node = node.next;
            count++;
        }
        int index = count / 2;
        node = head;
        for (int i = 1; i < index; i++) node = node.next;
        Console.WriteLine("c:" + node.val);
        node.next = node.next.next;

        return head;
    }
}