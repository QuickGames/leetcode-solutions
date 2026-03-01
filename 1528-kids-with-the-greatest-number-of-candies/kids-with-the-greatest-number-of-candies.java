class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int c : candies) max = Math.max(max, c);
        List<Boolean> result = new ArrayList();
        for (int c : candies) result.add(max <= c + extraCandies);
        return result;
    }
}