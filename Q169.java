169. Majority Element
Total Accepted: 87269 Total Submissions: 222619 Difficulty: Easy

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

public class Solution {
    public int majorityElement(int[] nums) {
       //search for linear time mjority vote















       if (nums == null || nums.length == 0) return 0;
       int num1 = nums[0];
       int count1 = 0;
       for (int i = 0; i < nums.length; i++){
          if (nums[i] == num1) count1++;
          else if (count1 == 0) {
              num1 = nums[i];
              count1 = 1;
          }
          else{
             count1--;
          }
       }
       return num1;
       //needs a secound round to check whether it is really majority
       //but the quesiton assume majoriy always exists, so no need to check in 2nd round
    }
}
