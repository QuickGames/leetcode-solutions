class Solution {

    public int minimumDeletions(String s) {
        if (s.length() == 1) return 0;
        int result = 0;

        char a = 'a';
        char b = 'b';

        int aMax = 0;
        int aCount = 0;
        int iMin = -1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == a) aCount++;
            else aCount--;
            if (aMax <= aCount){
                aMax = aCount;
                iMin = i;
            }
        }
        for (int i = 0; i < iMin; i++) {
            if (s.charAt(i) == b) result++;
        }

        int bMax = 0;
        int bCount = 0;
        int iMax = s.length();

        for (int i = s.length() - 1; iMin < i ; i--) {
            if (s.charAt(i) == b) bCount++;
            else bCount--;
            if (bMax <= bCount){
                bMax = bCount;
                iMax = i;
            }
        }
        for (int i = s.length() - 1; i >= iMax; i--) {
            if (s.charAt(i) == a) result++;
        }

        if (iMin + 1 <= iMax) return result;

        return result;
    }

    private int min(int a, int b) {
        if (a < b) return a;
        else return b;
    }

}