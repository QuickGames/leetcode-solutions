class Solution {
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        StringBuilder sbl = new StringBuilder();
        StringBuilder sbr = new StringBuilder();
        while (left <= right) {
            char cl = s.charAt(left);
            boolean isl = isIn(cl);
            char cr = s.charAt(right);
            boolean isr = isIn(cr);
            if (isl && isr) {
                sbl.append(cr);
                if (left == right) break;
                sbr.insert(0, cl);
                left++;
                right--;
            } else {
                if (!isl) {
                    sbl.append(cl);
                    left++;
                }
                if (!isr && left < right) {
                    sbr.insert(0, cr);
                    right--;
                }
            }
        }
        return sbl.toString() + sbr.toString();
    }
    private boolean isIn(char c) {
        return c == 'a' || c == 'A'
            || c == 'e' || c == 'E'
            || c == 'i' || c == 'I'
            || c == 'o' || c == 'O'
            || c == 'u' || c == 'U';
    }
}