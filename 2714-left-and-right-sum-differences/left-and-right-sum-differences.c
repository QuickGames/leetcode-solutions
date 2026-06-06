/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* leftRightDifference(int* nums, int numsSize, int* returnSize) {
    returnSize[0] = numsSize;
    int* result = malloc(sizeof(int) * numsSize);
    int rsum = 0;
    for(int i = numsSize - 1; 0 <= i; i--)
        rsum += nums[i];
    int lsum = 0;
    for (int i = 0; i < numsSize; i++) {
        lsum += nums[i];
        result[i] = abs(lsum - rsum);
        rsum -= nums[i];
    }
    return result;
}