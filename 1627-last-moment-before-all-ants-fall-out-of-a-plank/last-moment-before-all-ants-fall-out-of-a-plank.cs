public class Solution {
    public int GetLastMoment(int n, int[] left, int[] right) {
        int result = 0;

        foreach(int l in left) {
            result = getMax(result, l);
            if (result == n) return result;
        }
        foreach(int r in right) {
            result = getMax(result, n - r);
            if (result == n) return result;
        }

        return result;
    }

    private int getMax(int a, int b){
        if (a < b) return b;
        else return a;
    }

}