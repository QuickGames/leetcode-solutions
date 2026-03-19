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
    
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        List<ListNode>[] positives = new ArrayList[100_001];
        List<ListNode>[] negatives = new ArrayList[100_001];

        int minNegatives = 100_000;
        int maxPositives = -100_000;

        ListNode node = head;
        while (node != null) {

            minNegatives = Math.min(minNegatives, node.val);
            maxPositives = Math.max(maxPositives, node.val);

            int val = (0 <= node.val ? node.val : -node.val);
            List<ListNode>[] listGroup = (0 <= node.val ? positives : negatives);
            List<ListNode> list = listGroup[val];
            if (list == null) {
                list = new ArrayList<>();
                listGroup[val] = list;
            }
            list.add(node);
            node = node.next;
        }

        ListNode result = null;
        node = result;
        for (int i = -minNegatives; 0 <= i; i--) {
            List<ListNode> list = negatives[i];
            if (list != null) {
                for (ListNode listNode : list) {
                    if (result == null) {
                        result = listNode;
                        node = result;
                    }
                    node.next = listNode;
                    node = node.next;
                }
            }
        }
        for (int i = 0; i <= maxPositives; i++) {
            List<ListNode> list = positives[i];
            if (list != null) {
                for (ListNode listNode : list) {
                    if (result == null) {
                        result = listNode;
                        node = result;
                    } else {
                        node.next = listNode;
                        node = node.next;
                    }
                }
            }
        }
        node.next = null;

        return result;
    }

}