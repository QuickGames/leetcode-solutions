/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* deleteMiddle(struct ListNode* head) {
    if (head->next == NULL) return NULL;

    struct ListNode* node = head->next;
    struct ListNode* haveList = head;
    int i = 1;
    while (node->next && node->next->next) {
        haveList = haveList->next;
        node = node->next->next;
    }

    haveList->next = haveList->next->next;
    return head;
}