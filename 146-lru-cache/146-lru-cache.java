class LRUCache {
    HashMap<Integer, Integer> map;
    HashMap<Integer, Integer> freqMap;
    LinkedList<Integer> recentlyUsed;
    int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.freqMap = new HashMap<>();
        this.recentlyUsed = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (this.map.containsKey(key)) {
            if (this.recentlyUsed.size() > 0 && this.recentlyUsed.getFirst() == key) {
                this.recentlyUsed.removeFirst();
                freqMap.put(key, freqMap.get(key) - 1);
            }
            this.recentlyUsed.add(key);
            freqMap.put(key, freqMap.getOrDefault(key, 0) + 1);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.size() == capacity && !this.map.containsKey(key)) {
            while (this.recentlyUsed.size() > 0 && this.freqMap.get(this.recentlyUsed.getFirst()) > 1) {
                int keyRemoved =this.recentlyUsed.removeFirst();
                this.freqMap.put(keyRemoved, this.freqMap.get(keyRemoved) - 1);
            }
            if (this.recentlyUsed.size() > 0) {
                int keyRemoved = this.recentlyUsed.removeFirst();
                this.map.remove(keyRemoved);
                this.freqMap.remove(keyRemoved);
            }
        }
        if (this.recentlyUsed.size() > 0 && this.recentlyUsed.getFirst() == key) {
            this.recentlyUsed.removeFirst();
            freqMap.put(key, freqMap.get(key) - 1);
        }
        this.recentlyUsed.add(key);
        freqMap.put(key, freqMap.getOrDefault(key, 0) + 1);
        map.put(key, value);
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
