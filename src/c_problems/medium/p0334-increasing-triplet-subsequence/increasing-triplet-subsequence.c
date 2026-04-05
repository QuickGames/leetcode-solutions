bool increasingTriplet(int* nums, int numsSize) {

    int mins[numsSize];
    int maxes[numsSize];

    mins[0] = nums[0];
    maxes[numsSize - 1] = nums[numsSize - 1];

    for (int i = 1; i < numsSize; i++) {
        mins[i] = (mins[i - 1] < nums[i] ? mins[i - 1] : nums[i]);
        int li = numsSize - i - 1;
        maxes[li] = (maxes[numsSize - i] < nums[li] ? nums[li] : maxes[numsSize - i]);
    }

    for (int i = 0; i < numsSize; i++) {
        printf("i: %d; %d - %d\n", i, mins[i], maxes[i]);
    }

    for (int i = 0; i < numsSize; i++)
        if (mins[i] < nums[i] && nums[i] < maxes[i]) return true;
    return false;
}