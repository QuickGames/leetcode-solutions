/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
int** findDifference(int* nums1, int nums1Size, int* nums2, int nums2Size, int* returnSize, int** returnColumnSizes) {

    bool freq1[2001] = {false};
    for (int i = 0; i < nums1Size; i++)
        freq1[nums1[i] + 1000] = true;

    bool freq2[2001] = {false};
    for (int i = 0; i < nums2Size; i++)
        freq2[nums2[i] + 1000] = true;

    bool isAdded1[2001] = {false};
    int result1[nums1Size];
    int result1Size = 0;
    for (int i = 0; i < nums1Size; i++) {
        int n = nums1[i];
        int n1000 = n + 1000;
        if (!freq2[n1000] && !isAdded1[n1000]) {
            result1[result1Size] = n;
            result1Size++;
            isAdded1[n1000] = true;
        }
    }
    
    bool isAdded2[2001] = {false};
    int result2[nums2Size];
    int result2Size = 0;
    for (int i = 0; i < nums2Size; i++) {
        int n = nums2[i];
        int n1000 = n + 1000;
        if (!freq1[n1000] && !isAdded2[n1000]) {
            result2[result2Size] = n;
            result2Size++;
            isAdded2[n1000] = true;
        }
    }

    returnSize[0] = 2;
    *returnColumnSizes = malloc(sizeof(int) * 2);
    (*returnColumnSizes)[0] = result1Size;
    (*returnColumnSizes)[1] = result2Size;

    int** result = malloc(sizeof(int*) * 2);
    result[0] = malloc(sizeof(int) * result1Size);
    for (int i = 0; i < result1Size; i++)
        result[0][i] = result1[i];
    result[1] = malloc(sizeof(int) * result2Size);
    for (int i = 0; i < result2Size; i++)
        result[1][i] = result2[i];
    return result;
}