class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] ss = s.split(" ");
        for (int i = ss.length - 1; 0 <= i; i--) {
            String sss = ss[i];
            if (sss.isEmpty()) continue;
            if (!sb.isEmpty()) sb.append(" ");
            sb.append(sss);
        }

        return sb.toString();
    }
}