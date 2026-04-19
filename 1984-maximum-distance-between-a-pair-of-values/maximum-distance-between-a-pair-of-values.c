int maxDistance(int* nums1, int nums1Size, int* nums2, int nums2Size) {
    int result = 0;
    int index1 = nums1Size - 1;
    int index2 = nums2Size - 1;
    while (0 <= index1 && 0 <= index2) {
        if (nums1[index1] <= nums2[index2]) {
            if (index1 < index2)
                result = fmax(result, index2 - index1);
            index1--;
        } else
            index2--;
    }
    return result;
}