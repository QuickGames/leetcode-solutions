package java_problems.hard.p0352;

import java.util.ArrayList;
import java.util.List;

/**
 * @author QuickGames
 * @Difficulty: Hard
 * @Number: 352
 * @Title: Data Stream as Disjoint Intervals
 * @Language: Java
 * @Topic: Hash Table, Binary Search, Union-Find, Design, Data Stream, Ordered Set
 */
class SummaryRanges {

    private final boolean[] values;
    private int minValue = 10_002;
    private int maxValue = -1;

    public SummaryRanges() {
        this.values = new boolean[10_001];
    }

    public void addNum(int value) {
        values[value] = true;
        minValue = Math.min(minValue, value);
        maxValue = Math.max(maxValue, value);
    }

    public int[][] getIntervals() {
        List<int[]> list = new ArrayList<>();
        int[] interval = new int[2];
        boolean isStart = false;
        for (int i = minValue; i <= maxValue; i++) {
            if (values[i]) {
                if (!isStart) {
                    isStart = true;
                    interval[0] = i;
                }
                interval[1] = i;
            } else {
                if (isStart) {
                    isStart = false;
                    list.add(new int[]{interval[0], interval[1]});
                }
            }
        }
        if (isStart) list.add(interval);

        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
    }

}