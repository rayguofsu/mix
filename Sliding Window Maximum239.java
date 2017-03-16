Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

Therefore, return the max sliding window as [3,3,5,5,6,7].

Note:
You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?

Hint:

    How about using a data structure such as deque (double-ended queue)?
    The queue size need not be the same as the window’s size.
    Remove redundant elements and the queue should store only elements that need to be considered.

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {//remember: time complexity is O(n) not O(n*k) as see: each element only get in/out of the deque once, and the deque is like a doubled linkedlist; it can remove/add/get both first/last
        if (nums == null || nums.length == 0 || k <= 0) return new int[0];
        Deque<Integer> que = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++){
            while(!que.isEmpty() && nums[que.getLast()] <= nums[i]){
                que.removeLast();
            }
            que.addLast(i);
            
            if (i - que.getFirst() + 1 > k) que.removeFirst();
            
            if (i + 1 >= k) res[i + 1 - k] = nums[que.getFirst()];
            
            
        }
        return res;
    }
}
