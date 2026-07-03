/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

bool isValidBSTfull(struct TreeNode* node, long min, long max) {
    if (node == NULL) return true;
    int value = node->val;
    if (value <= min || max <= value) return false;
    bool is = isValidBSTfull(node->left, min, value);
    if (!is) return false;
    return isValidBSTfull(node->right, value, max);
}

bool isValidBST(struct TreeNode* root) {
    return isValidBSTfull(root, -2147483649, 2147483648);
}
