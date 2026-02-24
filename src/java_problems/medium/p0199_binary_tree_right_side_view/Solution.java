package java_problems.medium.p0199_binary_tree_right_side_view;

import java.util.ArrayList;
import java.util.List;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 199
 * Title: Binary Tree Right Side View
 * Language: Java
 * Topic: Tree, Depth-First Search, Breadth-First Search, Binary Tree
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
