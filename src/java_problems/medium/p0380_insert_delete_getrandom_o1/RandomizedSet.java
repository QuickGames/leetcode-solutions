package java_problems.medium.p0380_insert_delete_getrandom_o1;

import java.util.HashMap;
import java.util.Random;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 380
 * Title: Insert Delete GetRandom O(1)
 * Language: Java
 * Topic: Array, Hash Table, Math, Design, Randomized
 */
class RandomizedSet {

    private final Random random;
    private final HashMap<Integer, Integer> values;

    public RandomizedSet() {
        random = new Random();
        values = new HashMap<>();
    }

    public boolean insert(int val) {
        int value = values.getOrDefault(val, -1);
        if (value != -1) return false;
        values.put(val, 1);
        return true;
    }

    public boolean remove(int val) {
        int value = values.getOrDefault(val, -1);
        if (value == -1) return false;
        values.remove(val);
        return true;
    }

    public int getRandom() {
        int result = 0;
        if (!values.isEmpty()) {
            Object[] results = values.keySet().toArray();
            if (values.size() == 1) result = (int) results[0];
            else {
                int index = random.nextInt(values.size());
                result = (int) results[index];
            }
        }
        return result;
    }

}
