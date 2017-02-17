213. House Robber II
Total Accepted: 22294 Total Submissions: 75123 Difficulty: Medium

Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

public class Solution {
    /**
 * Either first or last could be robbed Thus do 2 passes of DP
 * First pass from house0 to house n-2; second pass from house1 to house n-1
 * O(n) time, O(1) space
 * */
    public int rob(int[] nums) {
















       if (nums == null || nums.length == 0) return 0;
       if (nums.length == 1) return nums[0];
       return Math.max(robHelper(nums, 1, nums.length -1), robHelper(nums, 0, nums.length - 2));
    }
    private int robHelper(int[] nums, int start, int end){
        int even = 0;
        int odd = 0;
        for (int i = start; i <= end; i++){
            if (i % 2 == 0){
                even = even + nums[i];
                even = (even > odd) ? even : odd;
            }
            else{
                odd = odd + nums[i];
                odd = (odd > even) ? odd : even;
            }
        }
        return Math.max(even, odd);
    }
}
