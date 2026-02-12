public class Solution {

    private Random random;
    private int[] blacklist;
    private int count;

    public Solution(int n, int[] blacklist) {
        this.random = new Random();
        this.blacklist = blacklist;
        Array.Sort(this.blacklist);
        this.count = n - this.blacklist.Length;
    }
    
    public int Pick() {
        int current = random.Next(0, count);
        foreach(int b in blacklist)
            if (b <= current) current++;
            else break;
        return current;
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.Pick();
 */