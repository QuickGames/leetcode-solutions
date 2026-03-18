int firstMissingPositive(int* nums, int numsSize) {

    bool isOk[numsSize + 1] = {};

    for (int i = 0; i < numsSize; i++)
        if (0 < nums[i] && nums[i] <= numsSize) isOk[nums[i]] = true;

    for (int i = 1; i < numsSize + 1; i++)
        if (!isOk[i]) return i;

    return numsSize + 1;
}