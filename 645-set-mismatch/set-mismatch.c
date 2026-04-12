/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* findErrorNums(int* nums, int numsSize, int* returnSize) {
    bool isExist[numsSize + 1];
    for (int i = 0; i < numsSize + 1; i++)
        isExist[i] = false;

    returnSize[0] = 2;
    int* result = malloc(returnSize[0] * sizeof(int));
    for (int i = 0; i < numsSize; i++) {
        if (isExist[nums[i]])
            result[0] = nums[i];
        isExist[nums[i]] = true;
    }
    for (int i = 1; i < numsSize + 1; i++)
        if (!isExist[i]) {
            result[1] = i;
            break;
        }
    return result;
}