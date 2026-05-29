int minElement(int* nums, int numsSize) {
    int result = 10001;
    for (int i = 0; i < numsSize; i++) {
        int n = nums[i];
        int sum = 0;
        while (0 < n) {
            sum += n % 10;
            n /= 10;
        }
        if (sum < result) result = sum;
    }
    return result;
}