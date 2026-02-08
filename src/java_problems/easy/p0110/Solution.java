package java_problems.easy.p0110;

/**
 * @author QuickGames
 * Difficulty: Easy
 * Number: 110
 * Title: Balanced Binary Tree
 * Language: Java
 * Topic: Tree, Depth-First Search, Binary Tree
 */
class Solution {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        else return isBalanced(root.left, root.right);
    }

    private boolean isBalanced(TreeNode leftNode, TreeNode rightNode) {
        int leftDepth = getDepth(leftNode);
        int rightDepth = getDepth(rightNode);
        if (1 < abs(leftDepth - rightDepth)) return false;
        boolean isLeft = isBalanced(leftNode);
        if (!isLeft) return false;
        return isBalanced(rightNode);
    }

    private int getDepth(TreeNode node) {
        if (node == null) return 0;
        return max(getDepth(node.left), getDepth(node.right)) + 1;
    }

    private int max(int a, int b) {
        return a < b ? b : a;
    }

    private int abs(int a) {
        return a < 0 ? -a : a;
    }

}
