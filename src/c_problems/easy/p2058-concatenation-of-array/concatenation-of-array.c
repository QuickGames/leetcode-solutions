/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* getConcatenation(int* nums, int numsSize, int* returnSize) {
    *returnSize = numsSize * 2;
    int* result = (int*)malloc(*returnSize * sizeof(int));
    int index = 0;
    for (int i = 0; i < 2; i++)
        for (int j = 0; j < numsSize; j++)
            result[index++] = nums[j];
    return result;
}