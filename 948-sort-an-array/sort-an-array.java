class Solution {

    public int[] sortArray(int[] nums) {
        sortArray(nums, 0, nums.length - 1);
        return nums;
    }

    private void sortArray(int[] nums, int startIndex, int endIndex) {
        if (endIndex - startIndex == 0) return;
        if (endIndex - startIndex == 1) {
            if (nums[startIndex] > nums[endIndex]) {
                int buf = nums[startIndex];
                nums[startIndex] = nums[endIndex];
                nums[endIndex] = buf;
            }
            return;
        }
        int centerIndex = (startIndex + endIndex) >> 1;
        sortArray(nums, startIndex, centerIndex);
        sortArray(nums, centerIndex + 1, endIndex);

        int[] bufNums = new int[endIndex - startIndex + 1];
        int leftIndex = startIndex;
        int rightIndex = centerIndex + 1;
        for (int i = 0; i < bufNums.length; i++) {
            int leftValue;
            if (leftIndex <= centerIndex) leftValue = nums[leftIndex];
            else {
                bufNums[i] = nums[rightIndex];
                rightIndex++;
                continue;
            }
            int rightValue;
            if (rightIndex <= endIndex) rightValue = nums[rightIndex];
            else {
                bufNums[i] = nums[leftIndex];
                leftIndex++;
                continue;
            }
            if (leftValue < rightValue) {
                bufNums[i] = nums[leftIndex];
                leftIndex++;
            } else {
                bufNums[i] = nums[rightIndex];
                rightIndex++;
            }
        }

        for (int i = 0; i < bufNums.length; i++) nums[startIndex + i] = bufNums[i];

    }

}