package java_problems.medium.p1339;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        String leftVal = "" + (left == null ? null : left.val);
        String rightVal = "" + (right == null ? null : right.val);
        return "[" + val + "," + leftVal + "," + rightVal + "]";
    }

}
