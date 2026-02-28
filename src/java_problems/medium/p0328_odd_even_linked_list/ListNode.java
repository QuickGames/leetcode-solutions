package java_problems.medium.p0328_odd_even_linked_list;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "[val:" + val + ";next:" + (next == null ? null : "ListNode") + "]";
    }

}