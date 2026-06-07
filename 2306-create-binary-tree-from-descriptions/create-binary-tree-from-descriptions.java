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
    public TreeNode createBinaryTree(int[][] descriptions) {
        
        Map<Integer, TreeNode> trees = new HashMap<>();
        Map<Integer, TreeNode> roots = new HashMap<>();

        for (int[] description : descriptions) {

            int value = description[0];
            TreeNode parent = trees.getOrDefault(value, null);
            if (parent == null) {
                parent = new TreeNode(value);
                trees.put(value, parent);
                roots.put(value, parent);
            }

            int hand = description[1];
            TreeNode child = trees.getOrDefault(hand, null);
            if (child == null) {
                child = new TreeNode(hand);
                trees.put(hand, child);
            } else {
                roots.remove(hand);
            }

            if (description[2] == 1)
                parent.left = child;
            else
                parent.right = child;

        }

        TreeNode result = null;
        for (Map.Entry<Integer, TreeNode> entry : roots.entrySet()) {
            result = entry.getValue();
            break;
        }

        return result;
    }
}