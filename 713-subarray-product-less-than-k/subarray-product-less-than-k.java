class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (current < k) result++;
            else continue;
            for (int j = i + 1; j < nums.length; j++) {
                current *= nums[j];
                if (current < k) result++;
                else break;
            }
        }
        return result;
    }
}