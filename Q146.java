
LRU Cach
sign and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item. 

Ans:
Used an ArrayList to maintain the least visited/set node. If the node was set before, find its index, delete it, and add it again.

Used a HashMap to maintain the cache table. If there is no space left, find the least used node (which should be the first node in the LinkedList, delete it in both the HashMap and ArrayList, and add the new one in both places.)

One of the trick thing is that -- if there are no spaces left (when left > 0 is false), removing the least used one and adding the new one, but this operation does not need to increment left anymore (it's just a replacement, and left will be kept at 0)!
public class LRUCache {
    private int cap;
    ArrayList<Integer> list;
    Map<Integer, Integer> map;
    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap();
        list = new ArrayList();
    }
    
    public int get(int key) {
        if (map.containsKey(key)){
            list.remove(list.indexOf(key));
            list.add(key);
            return map.get(key);
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)){
            list.remove(list.indexOf(key));

        }
        else if (list.size() == cap){
                int lastKey = list.get(0);
                map.remove(lastKey);
                list.remove(0);
        }
        map.put(key, value);
        list.add(key);
    }
}
