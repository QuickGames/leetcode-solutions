void rotate(int* nums, int numsSize, int k) {
    int n = k % numsSize;
    if (n == 0) return;

    int bufs[numsSize];
    for (int i = 0; i < numsSize; i++) {
        int ki = i + k;
        if (numsSize <= ki) ki %= numsSize;
        bufs[ki] = nums[i];
    }

    for (int i = 0; i < numsSize; i++)
        nums[i] = bufs[i];

}