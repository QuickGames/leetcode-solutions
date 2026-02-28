package java_problems.medium.p2236_maximum_twin_sum_of_a_linked_list;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 2130
 * Title: Maximum Twin Sum of a Linked List
 * Language: Java
 * Topic: Senior, Linked List, Two Pointers, Stack, Biweekly Contest 69
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
