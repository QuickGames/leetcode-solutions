package java_problems.easy.p1079_sum_of_root_to_leaf_binary_numbers;

/**
 * @author QuickGames
 * Difficulty: Easy
 * Number: 1022
 * Title: Sum of Root To Leaf Binary Numbers
 * Language: Java
 * Topic: Staff, Tree, Depth-First Search, Binary Tree, Weekly Contest 131
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
