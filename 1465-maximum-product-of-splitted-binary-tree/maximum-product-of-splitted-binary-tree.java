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
    
    private Map<TreeNode, Integer> nodesSums;

    public int maxProduct(TreeNode root) {
        nodesSums = new HashMap<>();
        TreeNode current = root;
        long result = 0;
        long cacheVal = 0;
        while (current != null) {
            long leftSum = getNodeSum(current.left);
            long rightSum = getNodeSum(current.right);
            long bufVal = cacheVal + current.val;
            long leftMain = (leftSum + bufVal) * rightSum;
            long rightMain = leftSum * (rightSum + bufVal);
            result = max(result, leftMain, rightMain);
            if (leftMain < rightMain) {
                current = current.left;
                cacheVal = bufVal + rightSum;
            } else {
                current = current.right;
                cacheVal = bufVal + leftSum;
            }
        }
        return (int) (result % 1_000_000_007);
    }

    private int getNodeSum(TreeNode treeNode) {

        if (treeNode == null) return 0;

        int sum = nodesSums.getOrDefault(treeNode, 0);
        if (0 < sum) return sum;

        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(treeNode);

        List<TreeNode> list = new ArrayList<>();
        list.add(treeNode);
        while (!list.isEmpty()) {
            TreeNode node = list.removeFirst();
            if (node.left != null) {
                list.add(node.left);
                nodes.add(node.left);
            }
            if (node.right != null) {
                list.add(node.right);
                nodes.add(node.right);
            }
        }

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.removeLast();
            int nodeSum = node.val;
            if (node.left != null)
                nodeSum += nodesSums.getOrDefault(node.left, 0);
            if (node.right != null)
                nodeSum += nodesSums.getOrDefault(node.right, 0);
            nodesSums.put(node, nodeSum);
        }

        return nodesSums.getOrDefault(treeNode, 0);
    }

    private long max(long n, long... nums) {
        long result = n;
        for (long num : nums)
            result = Math.max(result, num);
        return result;
    }

}