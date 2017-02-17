Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

public class Solution {//carry the same idea from 3Sum


















    public int threeSumClosest(int[] nums, int target) { //if do not sort, use native 3 embedded for loops,O(N^3)
       if (nums == null && nums.length < 3) return 0;
       Arrays.sort(nums);
       int sum = nums[0] + nums[1] + nums[2];
       for (int i = 0; i < nums.length; i++){
          if (i > 0 && nums[i] == nums[i - 1]) continue;
          int j = i + 1;
          int k = nums.length - 1;
          while (j < k){
             int newSum = nums[i] + nums[j] + nums[k];
             if (Math.abs(target - newSum) < Math.abs(sum - target)){
                 sum = newSum;
                // while(j < k && nums[j] == nums[j + 1]) j++; these two lines should be commented out
                // while(j < k && nums[k] == nums[k - 1]) k--;
             }
             if (newSum == target) return newSum;
             else if (newSum < target){ 
                 j++;
             }
             else{
                 k--;
             }
          }
       }
       return sum; 
    }
}


