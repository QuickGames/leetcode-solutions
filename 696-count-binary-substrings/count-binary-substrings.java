class Solution {

    public int countBinarySubstrings(String s) {
        int result = 0;

        int c0 = 0;
        int c1 = 0;

        char last = s.charAt(0);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (last != c) {
                if (c0 == 0 || c1 == 0) {
                    if (c == '0') c0++;
                    else c1++;
                } else {
                    result += min(c0, c1);
                    if (c == '0') {
                        c0 = 1;
                    } else {
                        c1 = 1;
                    }
                }
            } else {
                if (c == '0') c0++;
                else c1++;
            }
            last = c;
        }

        result += min(c0, c1);

        return result;
    }

    private int min(int a, int b) {
        return a < b ? a : b;
    }
    
}