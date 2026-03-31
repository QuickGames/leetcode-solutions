int maxSubArray(int* nums, int numsSize) {
    int result = -10000;

    int sum = 0;
    for (int i = 0; i < numsSize; i++) {
        sum += nums[i];
        result = fmax(result, sum);
        if (sum < 0) sum = 0;
    }
    
    return result;
}