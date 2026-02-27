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
    
    public int pairSum(ListNode head) {
        int[] nums = new int[100000];

        ListNode node = head;

        int index = 0;
        while (node != null) {
            nums[index] = node.val;
            node = node.next;
            index++;
        }

        int result = Integer.MIN_VALUE;

        for (int i = 0; i < index / 2; i++)
            result = Math.max(result, nums[i] + nums[index - i - 1]);

        return result;
    }

}