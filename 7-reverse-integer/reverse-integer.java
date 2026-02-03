class Solution {
    public int reverse(int x) {
        int isN = (x < 0 ? -1 : 1);
        StringBuilder sb = new StringBuilder();
        sb.append("" + x);
        sb.reverse();
        String s = sb.toString().replace("-", "");
        System.out.println(s);
        try {
            return Integer.valueOf(s) * isN;
        } catch (Exception e) {
            return 0;
        }
    }
}