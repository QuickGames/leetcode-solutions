package java_problems.medium.p1249;

/**
 * @author QuickGames
 * @Difficulty: Medium
 * @Number: 1249
 * @Title: Minimum Remove to Make Valid Parentheses
 * @Language: Java
 * @Topic: Staff, String, Stack, Weekly Contest 161
 */
class Solution {

    public String minRemoveToMakeValid(String s) {

        int[] forRemove = new int[s.length()];
        int forRemoveCount = 0;
        int rightCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(' -> forRemove[forRemoveCount++] = i;
                case ')' -> {
                    if (0 < forRemoveCount) forRemoveCount--;
                    else forRemove[forRemove.length - 1 - rightCount++] = i;
                }
            }
        }

        int indexL = 0;
        int indexR = 0;
        int[] forDel = new int[forRemoveCount + rightCount];
        for (int i = 0; i < forDel.length; i++) {
            int left = indexL < forRemoveCount ? forRemove[indexL] : Integer.MAX_VALUE;
            int right = indexR < rightCount ? forRemove[forRemove.length - 1 - indexR] : Integer.MAX_VALUE;
            if (left < right) forDel[i] = forRemove[indexL++];
            else forDel[i] = forRemove[forRemove.length - 1 - indexR++];
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int delIndex : forDel) {
            sb.append(s, index, delIndex);
            index = delIndex + 1;
        }
        sb.append(s, index, s.length());
        return sb.toString();
    }

}
