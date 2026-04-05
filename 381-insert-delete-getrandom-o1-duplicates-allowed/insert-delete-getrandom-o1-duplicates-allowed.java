class RandomizedCollection {

    private static class RCValue {

        private int count;
        private int[] addresses;
        private int addressesLength;

        public RCValue(int count) {
            this.count = count;
            this.addresses = new int[8];
        }

        public int getCount() {
            return count;
        }

        public void inc(int address) {
            count++;
            addresses[addressesLength++] = address;
            if (addressesLength == addresses.length) {
                int[] newValues = new int[addressesLength + (addressesLength >> 1)];
                System.arraycopy(addresses, 0, newValues, 0, addresses.length);
                addresses = newValues;
            }
        }

        public void dec() {
            count--;
            addressesLength--;
        }

        public void clear() {
            count = 0;
            addressesLength = 0;
        }

    }

    private final Random random;
    private final HashMap<Integer, RCValue> data;

    private int[] values;
    private int valuesLength;
    private boolean isValuesCompiled;

    public RandomizedCollection() {
        this.random = new Random();
        this.data = new HashMap<>();
        this.values = new int[8];
        this.valuesLength = 0;
        this.isValuesCompiled = true;
    }

    public boolean insert(int val) {
        boolean result = false;
        RCValue count = data.getOrDefault(val, null);
        if (count == null) {
            count = new RCValue(0);
            result = true;
        }
        count.inc(valuesLength);
        data.put(val, count);
        values[valuesLength++] = val;
        if (valuesLength == values.length) {
            int[] newValues = new int[valuesLength + (valuesLength >> 1)];
            System.arraycopy(values, 0, newValues, 0, values.length);
            values = newValues;
        }
        return result;
    }

    public boolean remove(int val) {
        RCValue count = data.getOrDefault(val, null);
        if (count == null) return false;
        if (count.getCount() == 1) data.remove(val);
        count.dec();
        isValuesCompiled = false;
        valuesLength--;
        return true;
    }

    private void compileValues() {
        valuesLength = 0;
        for (Map.Entry<Integer, RCValue> entry : data.entrySet()) {
            RCValue rcValue = entry.getValue();
            int count = rcValue.getCount();
            rcValue.clear();
            for (int i = 0; i < count; i++) {
                rcValue.inc(valuesLength);
                values[valuesLength++] = entry.getKey();
            }
        }
        isValuesCompiled = true;
    }

    public int getRandom() {
        if (!isValuesCompiled) compileValues();
        int index = random.nextInt(valuesLength);
        return values[index];
    }

}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */