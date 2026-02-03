class Solution {
    public int removeElement(int[] nums, int val) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i - result] = nums[i];
            if (nums[i] == val) {
                result++;
            }
        }
        return nums.length - result;
    }
}