class Solution {
        public String findDifferentBinaryString(String[] nums) {
        if (nums.length == 1) return nums[0].equals("1") ? "0" : "1";
        for (int i = 0; i < nums.length; i++) {
            String variant = "0".repeat(i) + "1" + "0".repeat(nums.length - i - 1);
            boolean isExist = false;
            for (String num : nums)
                if (num.equals(variant)){
                    isExist = true;
                    break;
                }
            if (!isExist) return variant;
        }
        return "1".repeat(nums.length);
    }
}