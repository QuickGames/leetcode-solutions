public class RecentCounter {

    private List<int> pings;

    public RecentCounter() {
        pings = new List<int>();
    }
    
    public int Ping(int t) {
        int result = 1;
        foreach(int ping in pings) {
            if (t - 3000 <= ping) result++;
        }
        pings.Add(t);
        return result;
    }

}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.Ping(t);
 */