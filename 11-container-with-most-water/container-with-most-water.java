class Solution {
    
    public int maxArea(int[] height) {
        int result = 0;

        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int leftHeigh = height[left];
            int rightHeigh = height[right];
            int cups = right - left;
            int minCap = Math.min(leftHeigh, rightHeigh);
            int capacity = minCap * cups;
            result = Math.max(result, capacity);

            if (leftHeigh < rightHeigh) left++;
            else right--;
        }

        return result;
    }

}