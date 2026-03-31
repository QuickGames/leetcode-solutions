class LFUCache {

    private final int capacity;
    private final int[] keyAddresses;
    // key, value[0] - key.
    // key, value[1] - value.
    // key, value[2] - lfu counter.
    // key, value[3] - lru counter.
    private final int[][] nodes;
    private int nodesLength;
    private int lruCounter;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.keyAddresses = new int[100_001];
        Arrays.fill(keyAddresses, -1);
        this.nodes = new int[capacity][4];
        this.nodesLength = 0;
        this.lruCounter = 0;
    }

    public int get(int key) {
        int index = keyAddresses[key];
        if (-1 < index) {
            int[] node = nodes[index];
            node[2]++;
            node[3] = lruCounter;
            lruCounter++;
            return node[1];
        }
        return -1;
    }

    public void put(int key, int value) {
        if (nodesLength == capacity) {
            boolean isExist = false;
            int[] minNode = nodes[0];
            int minNodeIndex = 0;
            for (int i = 0; i < nodesLength; i++) {
                if (key == nodes[i][0]) {
                    nodes[i][1] = value;
                    nodes[i][2]++;
                    nodes[i][3] = lruCounter;
                    isExist = true;
                    break;
                } else if (nodes[i][2] < minNode[2] || nodes[i][2] == minNode[2] && nodes[i][3] < minNode[3]) {
                    minNode = nodes[i];
                    minNodeIndex = i;
                }
            }
            if (!isExist) {
                keyAddresses[minNode[0]] = -1;
                minNode[0] = key;
                minNode[1] = value;
                minNode[2] = 1;
                minNode[3] = lruCounter;

                keyAddresses[key] = minNodeIndex;
            }

        } else {
            boolean isExist = false;
            for (int i = 0; i < nodesLength; i++) {
                if (key == nodes[i][0]) {
                    nodes[i][1] = value;
                    nodes[i][2]++;
                    nodes[i][3] = lruCounter;
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                keyAddresses[nodes[nodesLength][0]] = -1;
                nodes[nodesLength][0] = key;
                nodes[nodesLength][1] = value;
                nodes[nodesLength][2] = 1;
                nodes[nodesLength][3] = lruCounter;
                keyAddresses[key] = nodesLength;
                nodesLength++;
            }
        }
        lruCounter++;
    }

}
/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */