class Solution {
    public int minimumCost(int[] nums) {
        
        if (nums.length == 3) return nums[0] + nums[1] + nums[2];

        int min1 = nums[1];
        int min2 = nums[2];

        for (int i = 3; i < nums.length; i++) {
            int n = nums[i];
            if (n <= min1) {
                if (min1 < min2) min2 = min1;
                min1 = n;
            } else if (n <= min2) {
                min2 = n;
            }
        }

        return nums[0] + min1 + min2;
    }
}