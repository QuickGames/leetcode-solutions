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

    private Random random;
    private ListNode head;
    private ListNode currentNode;

    public Solution(ListNode head) {
        this.random = new Random();
        this.head = head;
        this.currentNode = head;
    }
    
    public int GetRandom() {
        int stepsSeed = random.Next(10, 20);
        int steps = random.Next(stepsSeed);
        for (int i = 0; i < steps; i++){
            currentNode = currentNode.next;
            if (currentNode == null) currentNode = head;
        }
        return currentNode.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.GetRandom();
 */