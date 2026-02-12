public class Solution {
    
    private Random random;
    private int[] w;
    private long weightAll;

    public Solution(int[] w) {
        this.random = new Random();
        this.w = w;
        foreach(int weight in w) {
            this.weightAll += weight;
        }
    }
    
    public int PickIndex() {
        long currentW = random.NextInt64(0, weightAll);
        long leftW = 0;
        for (int i = 0; i < w.Length; i++) {
            int weight = w[i];
            if (currentW < leftW + weight) return i;
            leftW += weight;
        }
        return 0;
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.PickIndex();
 */