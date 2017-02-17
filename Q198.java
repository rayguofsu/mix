198. House Robber
Total Accepted: 55494 Total Submissions: 166992 Difficulty: Easy

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

public class Solution {
    public int rob(int[] nums) {



















        //found on line: idea is to use even/odd to store current max at index i;
        //e.g. i = 20: then even is the max between including nums[20] and not including nums[20];
        //say if nums[19] is big and nums[22] is also big number; so we have even = without nums[20] but has nums[19]; it will later have chance to add even with nums[22] to get bigger number;
        //   50         1                1                       50
//even:      50                    max(50, 50+1) = 51
//odd:              max(50,1)=50                               max(50+50, 51) = 100
//so max(odd and even ) finaly gives 100
        if (nums == null || nums.length == 0) return 0;
        int even = 0;
        int odd = 0;
        for (int i = 0; i < nums.length; i++){
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
