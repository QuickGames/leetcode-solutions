bool check(int* nums, int numsSize) {
    int last = nums[0];
    int i = 1;
    for (; i < numsSize; i++) {
        if (nums[i] < last) {
            last = nums[i];
            break;
        }
        last = nums[i];
    }
    for (; i < numsSize; i++) {
        if (nums[i] < last || nums[0] < nums[i]) return false;
        last = nums[i];
    }
    return true;
}