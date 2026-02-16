class Solution {

    private final Random random;
    private final List<int[]> list;
    private final int n;
    private final float size;

    public Solution(int m, int n) {

        this.random = new Random();
        this.list = new ArrayList<>();
        this.n = n;
        this.size = m * n;

        reset();

    }

    public int[] flip() {
        int index = random.nextInt(list.size());
        int[] result = list.get(index);
        list.remove(index);
        return result;
    }

    public void reset() {
        list.clear();

        float step = get1f(size / 1000);
        float start = random.nextFloat(step);

        for (float i = 0; i < size; i += step) {
            float current = start + i;
            int mI = (int) (current / n);
            int nI = (int) (current % n);
            list.add(new int[]{mI, nI});
        }
    }

    private float get1f(float b) {
        return 1f < b ? b : 1f;
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */