package java_problems.medium.p0006;

/**
 * @author QuickGames
 * @Difficulty: Medium
 * @Number: 6
 * @Title: Zigzag Conversion
 * @Language: Java
 * @Topic: String
 */
class Solution {

    public String convert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++)
            sb[i] = new StringBuilder();

        int index = 0;
        boolean direction = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sb[index].append(c);
            if (1 < numRows) {
                index += (direction ? 1 : -1);
                if (index == 0) direction = true;
                else if (index == numRows - 1) direction = false;
            }
        }

        StringBuilder result = new StringBuilder(numRows);
        for (StringBuilder sbi : sb) result.append(sbi);
        return result.toString();
    }

}
