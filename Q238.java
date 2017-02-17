238. Product of Array Except Self
Total Accepted: 34262 Total Submissions: 82960 Difficulty: Medium

Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)


public class Solution {
    //use two pointer; first left pointer scanning from left first; then right pointer scanning from right
    //update current array entry first then prepare the product for next entry
    //for left, current array entry is the product of all entries on its left
    //for right pointer, current array entry will be updated by multiplying the product of all entries on itrs right; therefore except itself
    public int[] productExceptSelf(int[] nums) {










        int[] array = new int[nums.length];
        int leftProduct = 1;
        int rightProduct = 1;
        for (int i = 0; i < nums.length; i++){
            //update current array first
            array[i] = leftProduct;
            //prepare leftProduct to give it to next entry 
            leftProduct *= nums[i];  //leftProduct contains product of all left entries except current entry
        }
        for (int i = nums.length - 1; i >= 0; i--){
            array[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return array;
    }
}
