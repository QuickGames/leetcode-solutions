/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* pivotArray(int* nums, int numsSize, int pivot, int* returnSize) {
    *returnSize = numsSize;

    int less[numsSize];
    int lessSize = 0;
    int greater[numsSize];
    int greaterSize = 0;
    int pivotCount = 0;

    for (int i = 0; i < numsSize; i++) {
        int n = nums[i];
        if (n < pivot) less[lessSize++] = n;
        else if (pivot < n) greater[greaterSize++] = n;
        else pivotCount++;
    }

    int* result = malloc(sizeof(int) * numsSize);
    int resultIndex = 0;
    
    for (int i = 0; i < lessSize; i++)
        result[resultIndex++] = less[i];
    for (int i = 0; i < pivotCount; i++)
        result[resultIndex++] = pivot;
    for (int i = 0; i < greaterSize; i++)
        result[resultIndex++] = greater[i];

    return result;
}