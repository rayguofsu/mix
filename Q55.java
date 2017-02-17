Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false. 

public class Solution {
    //Very important: for this kind of question returning boolean: you should think in two direction to solve it
    //<i> under what condition return true; else return false;
    //<ii> under what condition return false; else return true;
    //for this question, first I was thinking to solve it using <i>, then realizing it is too hard to find all the true cases; then switch to using <ii> to solve it, now it gets much easier to find what condition should be false;
     public boolean canJump(int[] nums) {
         //other's solution: assume you have one runner running from left; max is the max index the runner can reach at current index i; however, if max < i, then it means from 0 to current index i, no matter how we jump, we cannot reach i; so return false;
        int max =0;
        for(int i=0;i<nums.length; i++){
            if(max<i) return false;
            max=Math.max(max, i+nums[i]);
        }
        return true;
    }
    /*public boolean canJump(int[] nums) {//my solution seems O(n^2) to me
        //the idea is to see if able to jump over zero; as the only reason to return false if could not jump over zero;
        if (nums == null || nums.length == 0) return false;
        if (nums.length == 1) return true;
        int i = nums.length - 2; //scanning for 0 from the right side
        while (i >= 0){  
           if (nums[i] == 0){
              int tmp = i;
              i = jumpOverZero(nums, i); //starting from 0 to see if can find earlier entry to jump over 0
              if (i == tmp) return false; //if cannot find earlier entry to jump over 0 return false here
           }
           i--;
        }
        return true;
    }

   private int jumpOverZero(int[] nums, int i){
     for (int j = 0; j < i; j++){ //scanning from 0 to then the while loop can resume scanning from it to save some time
        if (nums[j] + j >= i + 1){
            return j;
        }
     }
     return i;
   }
   */
}
