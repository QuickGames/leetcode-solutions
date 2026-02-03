class Solution {

    public int singleNumber(int[] nums) {
        int[] num1 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int j = isInclude(num1, nums[i], i);
            if (-1 < j) {
                num1[i] = 0;
                num1[j] = 0;
            } else{
                num1[i] = nums[i];
            }
        }
        int result = 0;
        for (int i = 0; i < num1.length; i++) {
            result += num1[i];
        }
        return result;
    }

    public int isInclude(int[] num1, int k, int max) {
        for (int j = 0; j < max; j++) {
            if (num1[j] == k){
                return j;
            }
        }
        return -1;
    }

}