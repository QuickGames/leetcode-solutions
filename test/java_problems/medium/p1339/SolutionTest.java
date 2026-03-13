package java_problems.medium.p1339;

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

@DisplayName("1339. Maximum Product of Splitted Binary Tree")
class SolutionTest {

    private static final String PATH = "test/java_problems/medium/p1339/";

    static Stream<Arguments> provideData() throws IOException {
        return Stream.of(
                Arguments.of(createTree(1, 2), 2),
                Arguments.of(createTree(1, 1, 1, 1, 1, 2, 10, null, null, null, null, 3), 100),

                Arguments.of(createTree(1, 2, 3, 4, 5, 6), 110),
                Arguments.of(createTree(1, null, 2, 3, 4, null, null, 5, 6), 90),
                Arguments.of(createTree("data33"), 763478770),
                Arguments.of(createTree("data53"), 757667725)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void solutionTest(TreeNode root, int expected) {
        Assertions.assertEquals(expected, new Solution().maxProduct(root));
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

    private static TreeNode createTree(String path) throws IOException {
        Integer[] nums = readArrayWithNulls(PATH + path);
        return createTree(nums);
    }

    static Integer[] readArrayWithNulls(String path) throws IOException {
        String content = Files.readString(Paths.get(path)).trim();
        String raw = content.substring(1, content.length() - 1);
        String[] parts = raw.split(",");

        Integer[] result = new Integer[parts.length];
        for (int i = 0; i < parts.length; i++) {
            String val = parts[i].trim();
            result[i] = val.equals("null") ? null : Integer.parseInt(val);
        }
        return result;
    }
}