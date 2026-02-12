public class Solution {
    public int MaximumGap(int[] nums) {
        if (nums.Length <= 1) return 0;
        Array.Sort(nums);
        int result = 0;
        for (int i = 0; i < nums.Length - 1; i++)
            result = Math.Max(result,  nums[i + 1] - nums[i]);
        return result;
    }
}