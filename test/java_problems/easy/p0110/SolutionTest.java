package java_problems.easy.p0110;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

@DisplayName("110. Balanced Binary Tree")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{1, null, 2, null, 3}), false),
                Arguments.of(buildTree(new Integer[]{3, 9, 20, null, null, 15, 7}), true),
                Arguments.of(buildTree(new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4}), false),
                Arguments.of(buildTree(new Integer[]{}), true),
                Arguments.of(buildTree(new Integer[]{1, null, 2, null, 3}), false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void constructTransformedArray(TreeNode root, boolean expected) {
        Solution solution = new Solution();
        Assertions.assertEquals(expected, solution.isBalanced(root));
    }

    public static TreeNode buildTree(Integer[] nodes) {
        if (nodes.length == 0) return null;
        TreeNode root = new TreeNode(nodes[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        for (int i = 1; i < nodes.length; i++) {
            TreeNode parent = q.poll();
            if (nodes[i] != null) {
                parent.left = new TreeNode(nodes[i]);
                q.add(parent.left);
            }
            if (++i < nodes.length && nodes[i] != null) {
                parent.right = new TreeNode(nodes[i]);
                q.add(parent.right);
            }
        }
        return root;
    }
}