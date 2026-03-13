package java_problems.hard.p0023;

/**
 * @author QuickGames
 * Difficulty: Hard
 * Number: 23
 * Title: Merge k Sorted Lists
 * Language: Java
 * Topic: Linked List, Divide and Conquer, Heap (Priority Queue), Merge Sort
 */
class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode[] nodes = new ListNode[10_000];
        int nodesCount = 0;

        for (int i = 0; i < lists.length; i++) {
            ListNode list = lists[i];
            while (list != null) {
                int nodeIndex = nodesCount;
                for (; 0 < nodeIndex; nodeIndex--) {
                    ListNode node = nodes[nodeIndex - 1];
                    if (list.val < node.val)
                        nodes[nodeIndex] = nodes[nodeIndex - 1];
                    else break;
                }
                nodes[nodeIndex] = list;
                nodesCount++;
                list = list.next;
            }

        }

        if (0 < nodesCount) {
            ListNode root = nodes[0];
            ListNode node = root;
            for (int i = 1; i < nodesCount; i++) {
                node.next = nodes[i];
                node = node.next;
            }
            node.next = null;
            return root;
        } else return null;
    }

}
