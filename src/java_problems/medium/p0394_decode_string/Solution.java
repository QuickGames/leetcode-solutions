package java_problems.medium.p0394_decode_string;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 394
 * Title: Decode String
 * Language: Java
 * Topic: Junior, String, Stack, Recursion
 */
class Solution {

    private int index;

    public String decodeString(String s) {
        index = 0;
        return decodeSubString(s);
    }

    private String decodeSubString(String s) {
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (; index < s.length(); index++) {
            char c = s.charAt(index);
            if ('0' <= c && c <= '9') count = count * 10 + Character.getNumericValue(c);
            else if (c == '[') {
                index++;
                String fragment = decodeSubString(s);
                result.append(fragment.repeat(count));
                count = 0;
            } else if (c == ']') break;
            else result.append(c);
        }

        return result.toString();
    }

}

/*
  Your Solution object will be instantiated and called as such:
  Solution obj = new Solution(m, n);
  int[] param_1 = obj.flip();
  obj.reset();
 */