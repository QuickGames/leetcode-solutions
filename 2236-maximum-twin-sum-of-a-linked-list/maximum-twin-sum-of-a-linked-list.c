/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
int pairSum(struct ListNode* head) {
    struct ListNode* nodes[100000];
    int nodesSize = 0;
    struct ListNode* node = head;
    while (node) {
        nodes[nodesSize++] = node;
        node = node->next;
    }
    int nodesSize2 = nodesSize / 2;
    int nodesSize1 = nodesSize - 1;
    int result = 0;
    for (int i = 0; i < nodesSize2; i++) {
        int sum = nodes[i]->val + nodes[nodesSize1 - i]->val;
        if (result < sum) result = sum;
    }
    return result;
}