219. Contains Duplicate II
Total Accepted: 45547 Total Submissions: 156796 Difficulty: Easy

Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k. 
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i]) && (i - map.get(nums[i]) <= k)){
                return true;
            }
            map.put(nums[i], i);  //if list already have key at nums[i]; then it will replace with new value
        }
        return false;
    }
}
        /*time limit solution
        Queue<Integer> q = new LinkedList<Integer>();
        int i = 0;
        while (i < k && i < nums.length){
            if (q.contains(nums[i])){
                return true;
            }
            q.add(nums[i]);
            i++;
        }
        for (int j = k; j < nums.length; j++){
            if (q.contains(nums[j])){
                return true;
            }
            else{
                q.add(nums[j]);
                q.poll();
            }
        }
        return false;
    }
    */
