package java_problems.easy.p1528_kids_with_the_greatest_number_of_candies;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int c : candies) max = Math.max(max, c);
        List<Boolean> result = new ArrayList();
        for (int c : candies) result.add(max <= c + extraCandies);
        return result;
    }
}