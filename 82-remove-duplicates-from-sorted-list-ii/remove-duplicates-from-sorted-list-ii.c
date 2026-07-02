/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* deleteDuplicates(struct ListNode* head) {
    if (head == NULL) return head;
    struct ListNode* re = malloc(sizeof(struct ListNode));
    re->next = NULL;
    struct ListNode* rn = re;

    struct ListNode* node = head;
    int del = head->val - 1;
    while (node->next != NULL) {
        struct ListNode* next = node->next;
        if (node->val == node->next->val) {
            del = node->val;
        } else {
            if (node->val != del) {
                rn->next = node;
                rn = rn->next;
                rn->next = NULL;
            }
        }
        node = next;
    }
    if (node->val != del) rn->next = node;
    return re->next;
}