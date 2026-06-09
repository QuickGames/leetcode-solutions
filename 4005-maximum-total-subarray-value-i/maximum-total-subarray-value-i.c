long long maxTotalValue(int* nums, int numsSize, int k) {
    long long max = nums[0];
    long long min = nums[0];
    for (int i = 0; i < numsSize; i++) {
        int n = nums[i];
        if (n < min) min = n;
        else if (max < n) max = n;
    }
    return (max - min) * k;
}