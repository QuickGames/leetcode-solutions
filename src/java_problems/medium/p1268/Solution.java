package java_problems.medium.p1268;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author QuickGames
 * @Difficulty: Medium
 * @Number: 1268
 * @Title: Search Suggestions System
 * @Language: Java
 * @Topic: Senior, Array, String, Binary Search, Trie, Sorting, Heap (Priority Queue), Weekly Contest 164
 */
class Solution {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();

        Arrays.sort(products);
        List<String> listProducts = new ArrayList<>(List.of(products));
        for (int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);
            List<String> list = new ArrayList<>();
            for (String s : listProducts)
                if (i < s.length() && c == s.charAt(i)) list.add(s);
            List<String> resultList = new ArrayList<>();
            for (int j = 0; j < Math.min(list.size(), 3); j++)
                resultList.add(list.get(j));
            result.add(resultList);
            listProducts = list;
        }

        return result;
    }

}
