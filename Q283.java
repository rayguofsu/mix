//Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//
//For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
//
//Note:
//
//    You must do this in-place without making a copy of the array.
//    Minimize the total number of operations.

//this is the same one as shown in char_move0s
public class Q283{
    public void moveZeroes(int[] nums) {










       int counter = 0;
       for (int i = 0; i < nums.length; i++){
           if (nums[i] == 0){
               counter++;
           }
           else{ //nums[i] !=
               if (counter != 0){ //if counter == 0; then the following code is wrong
                 nums[i - counter] = nums[i];
                 nums[i] = 0;
               }
           }
       }
    }
}
