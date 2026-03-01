package java_problems.medium.p0143_reorder_list;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 143
 * Title: Reorder List
 * Language: Java
 * Topic: Linked List, Two Pointers, Stack, Recursion
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
