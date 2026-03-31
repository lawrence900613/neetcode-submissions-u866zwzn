class LRUCache {
    Queue<Integer> queue;
    HashMap<Integer, Integer> map;
    int size = 0;
    int capacity = 0;
    public LRUCache(int capacity) {
       queue = new ArrayDeque<Integer>();
       map = new HashMap<Integer, Integer>();
       this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            queue.remove(key);
            queue.add(key);
            return map.get(key);
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            queue.remove(key);
            size = size - 1;
        } else if (size == capacity) {
            int removeKey = queue.poll();
            map.remove(removeKey);
            size = size -1;
        }
        map.put(key, value);
        queue.add(key);
        size += 1;
    }
}
