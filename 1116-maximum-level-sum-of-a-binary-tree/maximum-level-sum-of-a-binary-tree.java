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
    
    private int[] levels;

    public int maxLevelSum(TreeNode root) {
        levels = new int[10000];
        int maxLevel = addLevelValue(root, 1);

        int maxSum = Integer.MIN_VALUE;
        int result = 1;
        for (int level = 1; level <= maxLevel; level++) {
            int levelSum = levels[level];
            if (maxSum < levelSum) {
                maxSum = levelSum;
                result = level;
            }
        }
        return result;
    }

    private int addLevelValue(TreeNode node, int level) {
        if (node == null) return 0;
        levels[level] += node.val;
        int level1 = addLevelValue(node.left, level + 1);
        int level2 = addLevelValue(node.right, level + 1);
        return Math.max(level, Math.max(level1, level2));
    }

}