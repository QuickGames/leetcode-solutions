

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* shuffle(int* nums, int numsSize, int n, int* returnSize){
    returnSize[0] = numsSize;
    int* result = malloc(numsSize * sizeof(int));
    for (int i = 0; i < numsSize >> 1; i++) {
        int i2 = i << 1;
        result[i2] = nums[i];
        result[i2 + 1] = nums[i + n];
    }
    return result;
}