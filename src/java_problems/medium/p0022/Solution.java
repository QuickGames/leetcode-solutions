package java_problems.medium.p0022;

import java.util.ArrayList;
import java.util.List;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 22
 * Title: Generate Parentheses
 * Language: Java
 * Topic: String, Dynamic Programming, Backtracking
 */
class Solution {

    private void goThrough(Parenthes[] parentheses, int index, List<String> result) {
        for (int i = index; i < parentheses.length - 1; i++) {
            if (parentheses[i] == null) continue;
            if (parentheses[i].goal == i) continue;
            if (parentheses[i + 1] != null) {
                goThrough(copyParentheses(parentheses), i + 1, result);
                insertNullInParentheses(parentheses, i);
                result.add(parenthesesToString(parentheses));
            } else {
                parentheses[i + 1] = parentheses[i];
                parentheses[i] = null;
                result.add(parenthesesToString(parentheses));
            }
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        Parenthes[] parentheses = new Parenthes[n * 2];
        for (int i = 0; i < n; i++) parentheses[i] = new Parenthes(i * 2);
        result.add(parenthesesToString(parentheses));
        goThrough(parentheses, 1, result);
        return result;
    }

    private Parenthes[] copyParentheses(Parenthes[] parentheses) {
        Parenthes[] result = new Parenthes[parentheses.length];
        System.arraycopy(parentheses, 0, result, 0, parentheses.length);
        return result;
    }

    private void insertNullInParentheses(Parenthes[] parentheses, int index) {
        for (int i = parentheses.length - 1; index < i; i--)
            parentheses[i] = parentheses[i - 1];
        parentheses[index] = null;
    }

    private String parenthesesToString(Parenthes[] parentheses) {
        StringBuilder sb = new StringBuilder();
        for (Parenthes parenthesis : parentheses)
            sb.append(parenthesis == null ? ")" : "(");
        return sb.toString();
    }

    private static class Parenthes {
        private final int goal;

        public Parenthes(int goal) {
            this.goal = goal;
        }

    }

}
