package java_problems.medium.p1116_maximum_level_sum_of_a_binary_tree;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 1161
 * Title: Maximum Level Sum of a Binary Tree
 * Language: Java
 * Topic: Senior, Tree, Depth-First Search, Breadth-First Search, Binary Tree, Weekly Contest 150
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
