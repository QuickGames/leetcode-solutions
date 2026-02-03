class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> buf = new HashMap<>();
        for (int value : nums) {
            int b = buf.getOrDefault(value, 0);
            if (b == 0) buf.put(value, 1);
            else return true;
        }
        return false;
    }
}