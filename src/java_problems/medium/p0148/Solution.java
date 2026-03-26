package java_problems.medium.p0148;

import java.util.ArrayList;
import java.util.List;

/**
 * @author QuickGames
 * @Difficulty: Medium
 * @Number: 148
 * @Title: Sort List
 * @Language: Java
 * @Topic: Linked List, Two Pointers, Divide and Conquer, Sorting, Merge Sort
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

    public ListNode sortList3(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode[] nodes = new ListNode[50_001];
        nodes[0] = head;
        int nodesCount = 1;

        ListNode node = head.next;
        while (node != null) {
            for (int i = nodesCount; 0 < i; i--) {
                if (node.val < nodes[i - 1].val) {
                    nodes[i] = nodes[i - 1];
                    nodes[i - 1] = node;
                } else {
                    nodes[i] = node;
                    break;
                }
            }
            nodesCount++;
            node = node.next;
        }

        ListNode result = nodes[0];
        node = result;
        for (int i = 1; i < nodesCount; i++) {
            node.next = nodes[i];
            node = node.next;
        }
        node.next = null;

        return result;
    }

    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) return head;

        int count = 1;

        ListNode node = head.next;
        ListNode lastParent = head;
        while (node != null) {
            ListNode nextNode = node.next;
            ListNode nextLastParent = node;

            ListNode lastNode = null;
            ListNode current = head;
            for (int i = 0; i < count; i++) {
                if (node.val < current.val) {
                    lastParent.next = nextNode;
                    node.next = current;
                    nextLastParent = lastParent;
                    if (lastNode == null) head = node;
                    else lastNode.next = node;
                    break;
                }
                lastNode = current;
                current = current.next;
            }

            count++;
            lastParent = nextLastParent;
            node = nextNode;
        }

        return head;
    }

}
