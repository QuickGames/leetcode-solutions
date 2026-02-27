/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if (head == NULL) return head;

        ListNode* last = head;
        ListNode* node = head->next;
        last->next = NULL;
        if (node == NULL) return head;

        ListNode* next = node->next;
        if (next == NULL) node->next = last;

        while (next != NULL) {
            node->next = last;
            last = node;
            node = next;
            next = next->next;
        }

        node->next = last;
        return node;
    }
};