int findPeakElement(int* nums, int numsSize) {
    if (numsSize == 1) {
        return 0;
    } else if (numsSize == 2) {
        return (nums[0] < nums[1] ? 1 : 0);
    } else {
        for (int i = 1; i < numsSize - 1; i++)
            if (nums[i - 1] < nums[i] && nums[i + 1] < nums[i]) return i;
        return (nums[0] < nums[numsSize - 1] ? numsSize - 1 : 0);
    }
}