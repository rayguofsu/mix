347. Top K Frequent Elements

 Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note:

    You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
    Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
O(n) Solution - Bucket Sort
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length+1];
        for (int i = 0; i < nums.length; i++){
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0)+1);
        }
        for (int key:freqMap.keySet()){
            int freq = freqMap.get(key);
            if (bucket[freq] == null) bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = bucket.length-1; i >=0 && res.size() < k; i--){
            if (bucket[i] != null){
                res.addAll(bucket[i]);
            }
        }
        return res;
    }
}

