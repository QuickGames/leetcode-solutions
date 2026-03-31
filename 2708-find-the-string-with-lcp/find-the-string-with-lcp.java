class Solution {
    
    public String findTheString(int[][] lcp) {

        char[] chars = new char[lcp.length];
        char current = 'a';
        for (int row = 0; row < lcp.length; row++) {
            if (lcp[row][row] != lcp.length - row) return "";
            if (chars[row] != '\0') continue;
            if ('z' < current) return "";
            chars[row] = current;
            for (int col = row + 1; col < lcp[row].length; col++) {
                if (lcp[row][col] != lcp[col][row]) return "";
                else if (0 < lcp[row][col]) chars[col] = current;
            }
            current++;
        }

        int[][] lcpResult = new int[lcp.length][lcp[0].length];
        for (int row = 0; row < lcpResult.length; row++) {
            lcpResult[row][row] = lcpResult.length - row;
            char c = chars[row];
            for (int col = row + 1; col < lcpResult[row].length; col++) {
                int count = 0;
                if (c == chars[col]) {
                    for (int i = col; i < lcpResult[row].length; i++) {
                        if (chars[i - (col - row)] == chars[i]) count++;
                        else break;
                    }
                }
                lcpResult[row][col] = count;
                lcpResult[col][row] = count;
            }
            current++;
        }

        for (int row = 0; row < lcpResult.length; row++)
            for (int col = 0; col < lcpResult[row].length; col++)
                if (lcpResult[row][col] != lcp[row][col])
                    return "";

        return new String(chars);
    }

}