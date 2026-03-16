package java_problems.easy.p0118;

import java.util.ArrayList;
import java.util.List;

/**
 * @author QuickGames
 * Difficulty: Easy
 * Number: 118
 * Title: Pascal's Triangle
 * Language: Java
 * Topic: Array, Dynamic Programming
 */
class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> lastList = new ArrayList<>();
        lastList.add(1);
        result.add(lastList);
        for (int row = 1; row < numRows; row++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int col = 1; col < row; col++) {
                list.add(lastList.get(col - 1) + lastList.get(col));
            }
            list.add(1);
            result.add(list);
            lastList = list;
        }
        return result;
    }

}
