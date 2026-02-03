package easy.p3952_trionic_array_i;

/**
 * @author QuickGames
 * Difficulty: Easy
 * Number: 3637
 * Language: Java
 * Topic: Mid Level, Array, Weekly Contest 461
 */
class Solution {
    public boolean isTrionic(int[] nums) {
        int phase = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int n1 = nums[i];
            int n2 = nums[i + 1];
            if (n1 == n2) return false;
            if (n1 < n2) {
                if (phase == 0)
                    phase = 1;
                else if (phase != 1 && phase != 3) {
                    if (phase == 2) phase = 3;
                    else return false;
                }
            } else {
                if (phase == 0)
                    return false;
                else if (phase != 2) {
                    if (phase == 1) phase = 2;
                    else if (phase == 3) return false;
                }
            }
        }
        return phase == 3;
    }
}