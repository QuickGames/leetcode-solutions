package java_problems.medium.p2677_cousins_in_binary_tree_ii;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

@DisplayName("2641. Cousins in Binary Tree II")
class SolutionTest {

    static Stream<Arguments> provideData() throws IOException {
        return Stream.of(
                Arguments.of(
                        createTree(5, 4, 9, 1, 10, null, 7),
                        createTree(0, 0, 0, 7, 7, null, 11)
                ),
                Arguments.of(
                        createTree(3, 1, 2),
                        createTree(0, 0, 0)
                ),
                Arguments.of(
                        createTree(5, 4, 9, 1, 10, null, 7, 2, null, 3, 1, 1, 1),
                        createTree(0, 0, 0, 7, 7, null, 11, 6, null, 4, 4, 6, 6)
                ),
                Arguments.of(deserialize("test/java_problems/medium/p2641/data39.csv"), null)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(TreeNode root, TreeNode expected) {
        Solution sol = new Solution();
        TreeNode actual = sol.replaceValueInTree(root);
        if (expected != null) assertTreeEquals(expected, actual);
    }

    private static TreeNode createTree(Integer... nums) {
        if (nums == null || nums.length == 0) return null;

        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < nums.length) {
            TreeNode curr = queue.poll();

            if (nums[i] != null) {
                curr.left = new TreeNode(nums[i]);
                queue.add(curr.left);
            }
            i++;

            if (i < nums.length && nums[i] != null) {
                curr.right = new TreeNode(nums[i]);
                queue.add(curr.right);
            }
            i++;
        }
        return root;
    }

    void assertTreeEquals(TreeNode expected, TreeNode actual) {
        if (expected == null && actual == null) return;

        if (expected == null || actual == null) {
            Assertions.fail("Structure mismatch: one node is null, other is not");
        }

        Assertions.assertEquals(expected.val, actual.val, "Value mismatch at node");

        assertTreeEquals(expected.left, actual.left);
        assertTreeEquals(expected.right, actual.right);
    }

    public static TreeNode deserialize(String path) throws IOException {
        String data = Files.readString(Paths.get(path)).trim();
        if (data.equals("[]") || data.isEmpty()) return null;

        String[] nodes = data.substring(1, data.length() - 1).split(",");
        if (nodes[0].trim().equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0].trim()));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode curr = queue.poll();

            if (i < nodes.length && !nodes[i].trim().equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(nodes[i].trim()));
                queue.add(curr.left);
            }
            i++;

            if (i < nodes.length && !nodes[i].trim().equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(nodes[i].trim()));
                queue.add(curr.right);
            }
            i++;
        }
        return root;
    }

}