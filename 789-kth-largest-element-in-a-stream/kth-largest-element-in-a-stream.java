class KthLargest {

    private final int kIndex;
    private final int[] nums;

    public KthLargest(int k, int[] nums) {
        this.kIndex = k - 1;
        this.nums = new int[k + 1];
        Arrays.fill(this.nums, -10_001);
        for (int num : nums) add(num);
    }

    public int add(int val) {
        for (int i = nums.length - 2; 0 <= i; i--) {
            if (nums[i] < val) {
                nums[i + 1] = nums[i];
                nums[i] = val;
            }
        }
        return nums[kIndex];
    }

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */