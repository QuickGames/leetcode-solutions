public class Solution {
    public int FindDuplicate(int[] nums) {
        bool[] vals = new bool[nums.Length];
        for (int i = 0; i < nums.Length; i++) {
            if (vals[nums[i]]) return nums[i];
            else vals[nums[i]] = true;
        }
        return -1;
    }
}