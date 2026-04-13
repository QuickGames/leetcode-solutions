int getMinDistance(int* nums, int numsSize, int target, int start) {
    int result = 0;
    int nextIndex = start;
    int previousIndex = start;
    while (true) {
        if (nextIndex < numsSize) {
            if (nums[nextIndex] == target) {
                result = nextIndex - start;
                break;
            }
            nextIndex++;
        }
        if (0 <= previousIndex) {
            if (nums[previousIndex] == target) {
                result = start - previousIndex;
                break;
            }
            previousIndex--;
        }
    }
    return result;
}