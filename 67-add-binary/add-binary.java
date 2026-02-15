class Solution {
    public String addBinary(String a, String b) {
        
        int maxLength = a.length() < b.length() ? b.length() : a.length();
        int aAdd = a.length() - maxLength;
        int bAdd = b.length() - maxLength;

        StringBuilder sb = new StringBuilder();

        int c = 0;

        for (int i = maxLength - 1; 0 <= i; i--) {
            int ia = 0 <= i + aAdd ? (a.charAt(i + aAdd) == '0' ? 0 : 1) : 0;
            int ib = 0 <= i + bAdd ? (b.charAt(i + bAdd) == '0' ? 0 : 1) : 0;
            int ic = ia + ib + c;
            if (1 < ic) {
                c = 1;
                int sbc = ic % 2;
                sb.insert(0, "" + sbc);
            } else {
                c = 0;
                sb.insert(0, "" + ic);
            }
        }

        if (0 < c) sb.insert(0, "" + c);

        return sb.toString();
    }
}