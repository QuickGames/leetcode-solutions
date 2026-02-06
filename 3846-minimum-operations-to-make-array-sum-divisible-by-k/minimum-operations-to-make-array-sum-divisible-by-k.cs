public class Solution {
    public int MinOperations(int[] nums, int k) {
        int sum = 0;
        foreach (int n in nums) sum += n;
        return sum % k;
    }
}