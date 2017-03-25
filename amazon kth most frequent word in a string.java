Given a string, find the kth most frequent words in that string.  
Just use the same idea as k most; use a pq, to store the 


public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //Remember using PriorityQueue
        //Remember map.entrySet()
        PriorityQueue<Map.Entry<Integer, Integer>> que = new PriorityQueue<Map.Entry<Integer, Integer>>(new Comparator<Map.Entry<Integer, Integer>>(){
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2){
                return e1.getValue() - e2.getValue();
            }
        });
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            if (que.size() < k){
                que.offer(entry);
            }
            else{
                if (que.peek().getValue() < entry.getValue()){
                    que.poll();
                    que.offer(entry);
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!que.isEmpty()){
            list.add(que.poll().getKey());
        }
        return list;
    }
}
