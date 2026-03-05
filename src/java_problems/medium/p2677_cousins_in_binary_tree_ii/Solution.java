package java_problems.medium.p2677_cousins_in_binary_tree_ii;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 2641
 * Title: Cousins in Binary Tree II
 * Language: Java
 * Topic: Staff, Hash Table, Tree, Depth-First Search, Breadth-First Search, Binary Tree, Biweekly Contest 102
 */
class Solution {

    private int addNode(NodeWP[] nodes, int nodesLength, TreeNode node, TreeNode parent, int level) {
        if (node == null) return 0;
        NodeWP nodeWP = new NodeWP(node, parent, level);
        nodes[nodesLength] = nodeWP;
        return 1;
    }

    public TreeNode replaceValueInTree(TreeNode root) {

        NodeWP[] nodes = new NodeWP[100001];
        int nodesLength = 0;

        nodesLength += addNode(nodes, nodesLength, root, null, 0);
        int index = 0;
        while (nodes[index] != null) {
            NodeWP nodeWP = nodes[index];
            nodesLength += addNode(nodes, nodesLength, nodeWP.node.left, nodeWP.node, nodeWP.level + 1);
            nodesLength += addNode(nodes, nodesLength, nodeWP.node.right, nodeWP.node, nodeWP.level + 1);
            index++;
        }

        int left = 0;
        int right = 1;
        int level = 0;
        while (left < nodesLength) {
            if (nodes[left].level < level) {
                left++;
                right = left;
            } else if (nodes[right] != null && nodes[right].level <= level) {
                right++;
            } else {
                if (1 < right - left) {
                    for (int i = left; i <= right - 1; i++) {
                        NodeWP nodeWP = nodes[i];
                        for (int j = left; j <= right - 1; j++) {
                            NodeWP node2 = nodes[j];
                            if (nodeWP.parent != node2.parent)
                                nodeWP.newVal += node2.node.val;
                        }
                    }
                }
                level++;
                left = right;
                right++;
            }
        }

        for (int i = 0; i < nodesLength; i++) {
            NodeWP nodeWP = nodes[i];
            nodeWP.node.val = nodeWP.newVal;
        }
        return root;
    }

    private static class NodeWP {

        private final TreeNode node;
        private final TreeNode parent;
        private final int level;
        private int newVal;

        public NodeWP(TreeNode node, TreeNode parent, int level) {
            this.node = node;
            this.parent = parent;
            this.level = level;
        }

    }

}
