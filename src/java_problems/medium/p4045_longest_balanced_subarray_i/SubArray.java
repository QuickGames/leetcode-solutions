package java_problems.medium.p4045_longest_balanced_subarray_i;

import java.util.HashMap;

public class SubArray {

    private final HashMap<Integer, Integer> evenNumbers;
    private final HashMap<Integer, Integer> oddNumbers;

    private int result = 0;
    private int currentCount = 0;

    public SubArray(int n) {
        evenNumbers = new HashMap<>();
        oddNumbers = new HashMap<>();
        next(n);
    }

    public void next(int n) {
        currentCount++;
        if (isEven(n)) {
            int value = evenNumbers.getOrDefault(n, 0);
            if (value == 0) evenNumbers.put(n, 1);
        } else {
            int value = oddNumbers.getOrDefault(n, 0);
            if (value == 0) oddNumbers.put(n, 1);
        }
        if (evenNumbers.size() == oddNumbers.size()) {
            result = currentCount;
        }
    }

    public int getResult() {
        return result;
    }

    private boolean isEven(int n) {
        return n >> 1 << 1 == n;
    }

    @Override
    public String toString() {
        return "R: " + result + " B: " + (evenNumbers.size() == oddNumbers.size());
    }

}
