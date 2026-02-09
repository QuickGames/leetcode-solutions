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

    public TreeNode balanceBST(TreeNode root) {

        List<TreeNode> nodes = new ArrayList<>();
        extractNodes(nodes, root);
        nodes.sort(Comparator.comparingInt(o -> o.val));

        return getParentNode(nodes);

    }

    private TreeNode getParentNode(List<TreeNode> nodes) {
        if (nodes.isEmpty()) return null;
        if (nodes.size() == 1) return nodes.getFirst();

        TreeNode parent = null;

        int index = nodes.size() / 2;
        List<TreeNode> nodesLeft = new ArrayList<>();
        List<TreeNode> nodesRight = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            TreeNode current = nodes.get(i);
            if (i < index) nodesLeft.add(current);
            else if (index < i) nodesRight.add(current);
            else parent = current;
        }

        fillParent(parent, nodesLeft, nodesRight);

        return parent;
    }

    private void fillParent(TreeNode parent, List<TreeNode> nodesLeft, List<TreeNode> nodesRight) {
        parent.left = getParentNode(nodesLeft);
        parent.right = getParentNode(nodesRight);
    }

    private void extractNodes(List<TreeNode> nodes, TreeNode node) {
        if (node == null) return;
        nodes.add(node);
        extractNodes(nodes, node.left);
        node.left = null;
        extractNodes(nodes, node.right);
        node.right = null;
    }

}