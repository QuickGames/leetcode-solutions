package java_problems.medium.p0152_maximum_product_subarray;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 152
 * Title: Maximum Product Subarray
 * Language: Java
 * Topic: Array, Dynamic Programming
 */
class Solution {

    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        int result = Integer.MIN_VALUE;

        int[] foldedNums = new int[nums.length];
        int foldedCount = 0;
        int current = 1;
        int negativeCount = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0) {
                result = Math.max(result, 0);
                if (current != 1) foldedNums[foldedCount++] = current;
                int value = extractFolded(foldedNums, foldedCount, negativeCount);
                result = Math.max(result, value);
                negativeCount = 0;
                foldedCount = 0;
                current = 1;
            } else if (num == 1) {
                if (current != 1) foldedNums[foldedCount++] = current;
                foldedNums[foldedCount++] = num;
                current = 1;
            } else if (num < 0) {
                negativeCount++;
                if (current != 1) foldedNums[foldedCount++] = current;
                foldedNums[foldedCount++] = num;
                current = 1;
            } else current *= num;
        }
        if (current != 1) foldedNums[foldedCount++] = current;
        int value = extractFolded(foldedNums, foldedCount, negativeCount);
        result = Math.max(result, value);

        return result;
    }

    private int extractFolded(int[] foldedNums, int foldedCount, int negativeCount) {
        if (foldedCount == 0) return 0;
        else if (foldedCount == 1) return foldedNums[0];
        else if ((negativeCount & 1) == 0) {
            int result = 1;
            for (int i = 0; i < foldedCount; i++) result *= foldedNums[i];
            return result;
        } else {
            if (negativeCount == 1) {
                int leftWeight = 1;
                int rightWeight = 1;
                for (int i = 0; i < foldedCount; i++) {
                    int weight = foldedNums[i];
                    if (weight < 0) {
                        leftWeight = rightWeight;
                        rightWeight = 1;
                    } else {
                        rightWeight *= weight;
                    }
                }
                return Math.max(leftWeight, rightWeight);

            } else {

                int left = 0;
                int leftWeight = 1;
                for (; left < foldedCount; left++) {
                    leftWeight *= foldedNums[left];
                    if (foldedNums[left] < 0) break;
                }

                int right = foldedCount - 1;
                int rightWeight = 1;
                for (; 0 <= right; right--) {
                    rightWeight *= foldedNums[right];
                    if (foldedNums[right] < 0) break;
                }

                int centerWeight = 1;
                for (int i = left + 1; i < right; i++)
                    centerWeight *= foldedNums[i];

                return Math.min(leftWeight, rightWeight) * centerWeight;
            }

        }
    }

}
