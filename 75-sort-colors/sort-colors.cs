public class Solution {
    public void SortColors(int[] nums) {
        int[] colors = new int[3];
        for (int i = 0; i < nums.Length; i++)
            colors[nums[i]]++;
        int index = 0;
        for (int i = 0; i < colors.Length; i++)
            for (int j = 0; j < colors[i]; j++)
                nums[index++] = i;
    }
}