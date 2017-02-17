152. Maximum Product Subarray
Total Accepted: 48506 Total Submissions: 230381 Difficulty: Medium

Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6. 


public class Solution {
    //idea Dynamic Programming

     //This is similar to maximum subarray. Instead of sum, the sign of number affect the product value.

    //When iterating the array, each element has two possibilities: positive number or negative number. We need to track a minimum value, so that when a negative number is given, it can also find the maximum value. We define two local variables, one tracks the maximum and the other tracks the minimum.
    public int maxProduct(int[] nums) {
        //the main thing is to keep maxDP and minDP along traversing array
        if (nums == null || nums.length == 0) return 0;
        int maxDP = nums[0];
        int minDP = nums[0];
        int global = nums[0];
        for (int i = 1; i < nums.length; i++){
           int maxBuf = maxDP;
           maxDP = Math.max(maxDP * nums[i], Math.max(nums[i], minDP * nums[i])); //just ask youself, could minDP * nums[i] be max; 
           //could nums[i] itself be max, could maxDP * nums[i]; of course, so yes
           minDP = Math.min(minDP * nums[i], Math.min(nums[i], maxBuf * nums[i]));
           global = Math.max(maxDP, global);
        }
        return global;
    }
}
