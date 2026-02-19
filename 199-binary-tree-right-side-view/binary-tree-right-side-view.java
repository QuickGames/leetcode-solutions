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
    
    private int maxDepth;

    public List<Integer> rightSideView(TreeNode root) {
        maxDepth = -1;
        List<Integer> result = new ArrayList<>();
        rightSideView(result, root, 0);
        return result;
    }

    private void rightSideView(List<Integer> result, TreeNode node, int depth) {
        if (node == null) return;
        if (maxDepth < depth) {
            maxDepth = depth;
            result.add(node.val);
        }
        rightSideView(result, node.right, depth + 1);
        rightSideView(result, node.left, depth + 1);
    }

}