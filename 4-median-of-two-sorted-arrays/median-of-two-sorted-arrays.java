class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i1 = 0;
        int i2 = 0;
        int lastValue1 = 0;
        int lastValue2 = 0;
        int length = nums1.length + nums2.length;
        while (i1 + i2 <= length / 2) {
            if (nums1.length <= i1) {
                lastValue1 = lastValue2;
                lastValue2 = nums2[i2];
                i2++;
                continue;
            }
            if (nums2.length <= i2) {
                lastValue1 = lastValue2;
                lastValue2 = nums1[i1];
                i1++;
                continue;
            }
            if (nums1[i1] < nums2[i2]) {
                lastValue1 = lastValue2;
                lastValue2 = nums1[i1];
                i1++;
            } else {
                lastValue1 = lastValue2;
                lastValue2 = nums2[i2];
                i2++;
            }
        }
        if (length % 2 == 1) return lastValue2;
        else return (lastValue1 + lastValue2) / 2f;
    }
}