public class Solution {
    
    private Random random;
    private int[] source;

    public Solution(int[] nums) {
        random = new Random();
        source = nums;
    }
    
    public int[] Reset() {
        return source;
    }
    
    public int[] Shuffle() {
        int[] nums = new int[source.Length];
        for (int i = 0; i < source.Length; i++) nums[i] = source[i];
        for (int i = 0; i < source.Length; i++) {
            int index = random.Next(source.Length);
            int value = nums[index];
            nums[index] = nums[i];
            nums[i] = value;
        }
        return nums;
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.Reset();
 * int[] param_2 = obj.Shuffle();
 */