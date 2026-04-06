int findMaxConsecutiveOnes(int* nums, int numsSize) {
    int result = 0;
    int count = 0;
    for (int i = 0; i < numsSize; i++) {
        if (nums[i] == 1) count++;
        else {
            result = (result < count ? count : result);
            count = 0;
        }
    }
    return (result < count ? count : result);
}