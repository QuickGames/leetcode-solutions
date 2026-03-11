package java_problems.medium.p0146_lru_cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 146
 * Title: LRU Cache
 * Language: Java
 * Topic: Hash Table, Linked List, Design, Doubly-Linked List
 */
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