162. Find Peak Element
Total Accepted: 67729 Total Submissions: 204985 Difficulty: Medium

A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

click to show spoilers.
Note:

Your solution should be in logarithmic complexity.

public class Solution {
    public int findPeakElement(int[] nums) {
        //still BS; but not on value; but on trend
        int lo = 0;
        int hi = nums.length-1;
        while (lo < hi){//no == here //trend
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[mid + 1]){//as long as lo and hi within range; mid+1 always exist
                lo = mid + 1;
            }
            else{// mid > mid +1 //trend
                hi = mid;
            }
        }
        return lo;
    }
}


