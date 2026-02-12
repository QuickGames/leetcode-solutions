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

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */