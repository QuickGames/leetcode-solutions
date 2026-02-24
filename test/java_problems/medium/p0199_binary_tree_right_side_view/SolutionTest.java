package java_problems.medium.p0199_binary_tree_right_side_view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

@DisplayName("199. Binary Tree Right Side View")
class SolutionTest {
    static Stream<Arguments> provideData() {
        return Stream.of(
                // root = [1,2,3,null,5,null,4] -> [1,3,4]
                Arguments.of(
                        createTree(new Integer[]{1, 2, 3, null, 5, null, 4}),
                        new ArrayList<>(Arrays.asList(1, 3, 4))
                ),
                // root = [1,2,3,4,null,null,null,5] -> [1,3,4,5]
                Arguments.of(
                        createTree(new Integer[]{1, 2, 3, 4, null, null, null, 5}),
                        new ArrayList<>(Arrays.asList(1, 3, 4, 5))
                ),
                // root = [1,null,3] -> [1,3]
                Arguments.of(
                        createTree(new Integer[]{1, null, 3}),
                        new ArrayList<>(Arrays.asList(1, 3))
                ),
                // root = [] -> []
                Arguments.of(
                        createTree(new Integer[]{}),
                        new ArrayList<Integer>()
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(TreeNode root, List<Integer> expected) {
        Assertions.assertEquals(expected, new Solution().rightSideView(root));
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