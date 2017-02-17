268. Missing Number
Total Accepted: 38503 Total Submissions: 98543 Difficulty: Medium

Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity? 

public class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        int sum2 = 0;
        for (int j = 0; j < nums.length; j++){
            sum2 += j;
        }
        return nums.length - (sum - sum2);
    }
}
