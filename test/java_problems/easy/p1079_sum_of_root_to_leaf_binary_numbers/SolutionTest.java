package java_problems.easy.p1079_sum_of_root_to_leaf_binary_numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

@DisplayName("1022. Sum of Root To Leaf Binary Numbers")
class SolutionTest {

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(createTree(new Integer[]{1}), 1),
                Arguments.of(createTree(new Integer[]{1, 0, 1, null, 1, 0, 1}), 18),
                Arguments.of(createTree(new Integer[]{1, 0, 1, 0, 1, 0, 1}), 22),
                Arguments.of(createTree(new Integer[]{0}), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(TreeNode root, int expected) {
        Solution sol = new Solution();
        int actual = sol.sumRootToLeaf(root);

        Assertions.assertEquals(expected, actual,
                String.format("Sum mismatch! Expected: %d, but got: %d", expected, actual));
    }

    private static TreeNode createTree(Integer[] nums) {
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

}