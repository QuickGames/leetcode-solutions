package java_problems.medium.p1285_balance_a_binary_search_tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

@DisplayName("1382. Balance a Binary Search Tree")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(
                        buildTree(new Integer[]{1, 2, 3, 4, 5, 6, 7}),
                        buildTree(new Integer[]{1, 2, 3, 4, 5, 6, 7})
                ),
                Arguments.of(
                        buildTree(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21}),
                        buildTree(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21})
                ),
                Arguments.of(
                        buildTree(new Integer[]{1, null, 2, null, 3, null, 4, null, null}),
                        buildTree(new Integer[]{2, 1, 3, null, null, null, 4})
                ),
                Arguments.of(
                        buildTree(new Integer[]{2, 1, 3}),
                        buildTree(new Integer[]{2, 1, 3})
                )
        );
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

    private void assertTreeEquals(TreeNode expected, TreeNode actual) {
        if (expected == null && actual == null) return;
        if (expected == null || actual == null) {
            Assertions.fail("expected == null || actual == null");
        }
        Assertions.assertEquals(expected.val, actual.val);
        assertTreeEquals(expected.left, actual.left);
        assertTreeEquals(expected.right, actual.right);
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void balanceBSTTest(TreeNode root, TreeNode expected) {
        Solution solution = new Solution();
        assertTreeEquals(expected, solution.balanceBST(root));
    }

}