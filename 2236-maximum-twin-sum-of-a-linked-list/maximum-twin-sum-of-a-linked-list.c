/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
int pairSum(struct ListNode* head) {
    int values[100000];
    int valuesSize = 0;
    struct ListNode* node = head;
    while (node) {
        values[valuesSize++] = node->val;
        node = node->next;
    }
    int valuesSize2 = valuesSize / 2;
    int valuesSize1 = valuesSize - 1;
    int result = 0;
    for (int i = 0; i < valuesSize2; i++) {
        int sum = values[i] + values[valuesSize1 - i];
        if (result < sum) result = sum;
    }
    return result;
}