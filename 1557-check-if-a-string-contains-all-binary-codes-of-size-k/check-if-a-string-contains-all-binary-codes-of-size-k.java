class Solution {

    public boolean hasAllCodes(String s, int k) {
        int[] includes = new int[(int) Math.pow(2, k)];
        for (int i = 0; i < s.length() - k + 1; i++) {
            String sub = s.substring(i, i + k);
            int index = Integer.parseInt(sub, 2);
            includes[index] = 1;
        }
        for (int include : includes) {
            if (include == 0) return false;
        }
        return true;
    }

}