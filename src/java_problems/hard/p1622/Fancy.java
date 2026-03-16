package java_problems.hard.p1622;

/**
 * @author QuickGames
 * Difficulty: Hard
 * Number: 1622
 * Title: Fancy Sequence
 * Language: Java
 * Topic: Principal, Math, Design, Segment Tree, Biweekly Contest 37
 */
class Fancy {

    private static final int MODULO = 1_000_000_007;

    private final int[] values;
    private int valuesCount;

    public Fancy() {
        values = new int[100_000];
        valuesCount = 0;
    }

    public void append(int val) {
        values[valuesCount++] = val;
    }

    public void addAll(int inc) {
        for (int i = 0; i < valuesCount; i++) {
            long val = (long) values[i] + inc;
            values[i] = (int) (val < MODULO ? val : (val % MODULO));
        }
    }

    public void multAll(int m) {
        for (int i = 0; i < valuesCount; i++) {
            long val = (long) values[i] * m;
            values[i] = (int) (val % MODULO);
        }
    }

    public int getIndex(int idx) {
        if (valuesCount <= idx) return -1;
        return values[idx];
    }

}
