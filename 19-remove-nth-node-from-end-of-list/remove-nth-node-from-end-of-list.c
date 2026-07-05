/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* removeNthFromEnd(struct ListNode* head, int n) {
    if (head->next == NULL) return NULL;

    struct ListNode* node = head;
    for (int i = 0; i < n; i++)
        node = node->next;
    if (node == NULL) {
        head = head->next;
    } else {
        struct ListNode* nodeThis = head;
        while (node->next != NULL) {
            node = node->next;
            nodeThis = nodeThis->next;
        }
        nodeThis->next = nodeThis->next->next;
    }
    return head;
}