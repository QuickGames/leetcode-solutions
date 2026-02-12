class Solution {

    private class Rect {

        private final int x1;
        private final int y1;
        private final int x2;
        private final int y2;

        private final long wRows;
        private final long wCols;
        private final long weight;

        public Rect(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            wRows = y2 - y1 + 1;
            wCols = x2 - x1 + 1;

            weight = wCols * wRows;
        }

        public long getWeight() {
            return weight;
        }

        public int[] getCoordsByWeight(long wIndex) {
            long row = wIndex / wCols;
            long col = wIndex % wCols;

            return new int[]{(int) (x1 + col), (int) (y1 + row)};
        }
    }

    private final Random random;
    private final List<Rect> rects;
    private final long weightAll;

    public Solution(int[][] rects) {
        this.random = new Random(1);
        this.rects = new ArrayList<>();
        long weightAll = 0;
        for (int[] coords : rects) {
            Rect rect = new Rect(coords[0], coords[1], coords[2], coords[3]);
            this.rects.add(rect);
            weightAll += rect.getWeight();
        }
        this.weightAll = weightAll;
    }

    public int[] pick() {
        long currentWeight = (long) (random.nextFloat() * weightAll);
        long leftWeight = 0;
        for (Rect rect : rects) {
            if (currentWeight < leftWeight + rect.getWeight()) {
                return rect.getCoordsByWeight(currentWeight - leftWeight);
            }
            leftWeight += rect.getWeight();
        }

        return new int[]{0, 0};
    }
    
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */