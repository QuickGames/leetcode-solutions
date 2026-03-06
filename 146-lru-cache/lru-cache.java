class LRUCache {

    private final int capacity;
    private final List<Integer> keys;
    private final HashMap<Integer, Integer> hashmap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.keys = new ArrayList<>(capacity);
        this.hashmap = new HashMap<>((int) (capacity / 0.76f));
    }

    public int get(int key) {
        int value = hashmap.getOrDefault(key, -1);
        if (-1 < value) {
            keys.remove((Integer) key);
            keys.add(key);
        }
        return value;
    }

    public void put(int key, int value) {
        if (-1 < hashmap.getOrDefault(key, -1)) {
            keys.remove((Integer) key);
        } else if (keys.size() == capacity) {
            int removed = keys.removeFirst();
            hashmap.remove(removed);
        }
        keys.add(key);
        hashmap.put(key, value);
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */