220. Contains Duplicate III
Total Accepted: 21460 Total Submissions: 119682 Difficulty: Medium

Given an array of integers, find out whether there are two distinct indices i and j in the array such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k. 

/*public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
         //this is my solution which sucks, even the below naive solution codes much cleaner
        int dist = Math.min(Math.abs(k), nums.length -1);
        int val = Math.abs(t);
        //using sliding window of size dist+1
        //two steps
        //first step check first on windown starting from 0
        //2nd step is to move window step by step to check it
        
        //first step
        for (int i = 0; i <= dist; i++){
            for (int j = i + 1; j <= dist; j++){
                if (Math.abs(nums[i] - nums[j]) <= val){
                   return true;
                }
            }
        }
        //2nd step
        int start = 0;
        while (++dist < nums.length){
           for (int i = start; i < dist; i++){
               if (Math.abs(nums[i] - nums[dist]) <= val){
                  return true;
               }
           }
           start++;
        }
        return false;
    }
}
*/

/*//the naive solution: iteratively check all indices with difference not larger than k
        //Time complexity is O(nk), OK when k is small.
        for (int i = 0; i < nums.length - k; i++) {
            for (int j = i + 1; j <= i + k; j++) {
                if (nums[i] - nums[j] >= -t && nums[i] - nums[j] <= t) return true;
            }
        }
        return false;
*/

/*Java/Python one pass solution, O(n) time O(n) space using buckets
+38 votes
1,537 views

The idea is like the bucket sort algorithm. Suppose we have consecutive buckets covering the range of nums with each bucket a width of (t+1). If there are two item with difference <= t, one of the two will happen:

(1) the two in the same bucket
(2) the two in neighbor buckets

For detailed explanation see my blog here

Java

private int getID(int i, int t) {
    return i < 0 ? (i + 1) / t - 1 : i / t;
}

public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) { //this is complicated to understand; see the oop solution below
    if (t < 0) return false;
    int n = nums.length;
    Map<Integer, Integer> d = new HashMap<>();
    t++;
    for (int i = 0; i < n; ++i) {
        if (i > k) d.remove(getID(nums[i - k - 1], t));
        int m = getID(nums[i], t);
        if (d.containsKey(m)) return true;
        if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < t) return true;
        if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < t) return true;
        d.put(m, nums[i]);
    }
    return false;
}

*/

//This is my first thought on this problem, sort the input with index info saved and search as far as the value difference is less than or equal to k. For worst case scenario, the search would be O(n^2), but this solution is surprisingly fast, my thought would be the test cases are not covering the case that all the input is within the value difference of k.
public class Solution {
     class Pair{
        int val;
        int index;
        Pair(int v, int i){
          this.val = v;
          this.index = i;
        }
     }
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null) return false;
        Pair[] numSort = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++){
            numSort[i] = new Pair(nums[i], i);
           //wrong numSort[i].val = nums[i];
           //wrong numSort[i].index = i;
        }
        Arrays.sort(numSort, new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2){              
                return p1.val - p2.val;
            }
        });
        for (int j = 0; j < nums.length; j++){
           for (int i = j+1; i < nums.length && Math.abs((long)numSort[i].val - (long)numSort[j].val) <= (long)t; i++){
               if (Math.abs(numSort[i].index - numSort[j].index) <= k) return true;
           }
        }
        return false;
     }
}
