class Solution {
    public int maxOperations(int[] nums, int k) {
        int result = 0;
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < k) left++;
            else if (k < sum) right--;
            else {
                result++;
                left++;
                right--;
            }
        }

        return result;
    }
}