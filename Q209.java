209. Minimum Size Subarray Sum
Total Accepted: 28602 Total Submissions: 111239 Difficulty: Medium

Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

click to show more practice.
More practice:

If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). (guess this is by sort it first; then do binary search)
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        
    }
}

dynamic sliding window
We will maintain a window that grows until sum reach the given sum. Once the window grows to sum at least s then we can start shirking the window from left with the hope to find a smaller window. We shrink until sum falls below s. Then we can grow the window on right again and so on. We keep this procedure of growing-shrinking until the window start reaches the end of the array. Below is the implementation of the above idea which runs in O(n) time and O(1) space.

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {













       int start = 0;
       int end = 0;
       int cuSum = 0;
       int minLen = Integer.MAX_VALUE;
       while (end < nums.length){
          //if current window doesn't add up to the given sum then 
          //strech the window to right
          if (cuSum < s){
             cuSum += nums[end];
             end++;
          }
          //if current window adds up to at least given sum then
          //we can shrink the window 
          while (cuSum >= s){ //cannot use else if, as else if will miss cuSum at last entry
             minLen = Math.min(minLen, end - start);
             cuSum -= nums[start];
             start++;
          }
       }
       return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}

