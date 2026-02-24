/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public int sumRootToLeaf(TreeNode root) {
        return sumRootToLeaf(root, 0);
    }

    private int sumRootToLeaf(TreeNode node, int weight) {
        if (node == null) return 0;
        weight <<= 1;
        weight |= node.val;
        int left = sumRootToLeaf(node.left, weight);
        int right = sumRootToLeaf(node.right, weight);
        int lr = left + right;
        return (lr == 0 ? weight : lr);
    }

}