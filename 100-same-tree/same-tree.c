/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
bool isSameTree(struct TreeNode* p, struct TreeNode* q) {
    if (p == NULL && q == NULL) return true;
    if (p == NULL && q != NULL) return false;
    if (p != NULL && q == NULL) return false;

    if (p->val != q->val) return false;
    bool isLeft = false;
    if (p->left != NULL && q->left != NULL)
        isLeft = isSameTree(p->left, q->left);
    else if (p->left == NULL && q->left == NULL)
        isLeft = true;
    else
        return false;
    bool isRight = false;
    if (p->right != NULL && q->right != NULL)
        isRight = isSameTree(p->right, q->right);
    else if (p->right == NULL && q->right == NULL)
        isRight = true;
    else
        return false;
    return (isLeft && isRight);
}