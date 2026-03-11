class Solution {

    public int rob(int[] nums) {
        int result = 0;

        int right = 0;

        int current = 0;
        int curRobs = 0;
        int curNotRobs = 0;
        boolean isRobbed = false;
        while (right < nums.length) {
            int n = nums[right];
            if (isRobbed) {
                int nextCurrent = current - n;
                curNotRobs+=n;
                if (nextCurrent < 0) {
                    current = -nextCurrent;
                    isRobbed = false;
                    int buf = curRobs;
                    curRobs = curNotRobs;
                    curNotRobs = buf;
                } else {
                    result += curRobs;
                    current = 0;
                    curRobs = 0;
                    curNotRobs = 0;
                }
            } else {
                curRobs += n;
                current += n;
            }
            right++;
            isRobbed = !isRobbed;
        }
        result += curRobs;

        return result;
    }

}