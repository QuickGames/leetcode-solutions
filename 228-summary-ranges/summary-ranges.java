class Solution {
    
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();

        List<String> result = new ArrayList<>();

        int leftIndex = 0;
        int last = nums[leftIndex];

        for (int i = 1; i < nums.length; i++) {
            if (1 < (long)nums[i] - last) {
                if (leftIndex == i - 1) result.add("" + nums[leftIndex]);
                else result.add(nums[leftIndex] + "->" + nums[i - 1]);
                leftIndex = i;
            }
            last = nums[i];
        }

        if (leftIndex == nums.length - 1) result.add("" + nums[leftIndex]);
        else result.add(nums[leftIndex] + "->" + nums[nums.length - 1]);

        return result;
    }

}